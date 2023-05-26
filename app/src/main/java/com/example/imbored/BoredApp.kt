package com.example.imbored

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.imbored.ui.BoredViewModel
import com.example.imbored.ui.activity_details_route.ActivityDetailsRoute
import com.example.imbored.ui.activity_route.ActivityRoute
import com.example.imbored.ui.category_route.CategoryRoute
import com.example.imbored.ui.common.AppBar
import com.example.imbored.ui.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoredApp(
    windowSize: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screen.valueOf(
        backStackEntry?.destination?.route ?: Screen.CATEGORY_LIST.name
    )
    val viewModel: BoredViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    /*Expose state to cause refresh when values update*/
    val selectedCategory = state.category
    val selectedActivity = state.activity
    val isNavBackward = state.isNavBackward

    val appActivity: Activity? = if (LocalContext.current is Activity){
        LocalContext.current as Activity
    } else {
        null
    }

    val navigateBack = {
        viewModel.updateIsNavBackward(isNavBackward = true)
        if ( navController.previousBackStackEntry != null ){
            navController.navigateUp()
        } else {
            appActivity?.finish()
        }
    }

    val isExpandedScreen = (windowSize != WindowWidthSizeClass.Compact)

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navigateBack() }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.CATEGORY_LIST.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screen.CATEGORY_LIST.name) {
                CategoryRoute(
                    categories = viewModel.getCategories(),
                    categorySelect = { selectedCategory ->
                        viewModel.updateCategory(selectedCategory)
                        if (!isExpandedScreen) {
                            viewModel.updateIsNavBackward(isNavBackward = false)
                            navController.navigate(Screen.ACTIVITY_LIST.name)
                        }
                    },
                    activities = viewModel.getCurrentActivities(),
                    activitySelect = { selectedActivity ->
                        viewModel.updateActivity(selectedActivity)
                        viewModel.updateIsNavBackward(isNavBackward = false)
                        navController.navigate(Screen.ACTIVITY_LIST.name)
                    },
                    onBackPress = {navigateBack()},
                    isExpandedScreen = isExpandedScreen
                )
            }
            composable(route = Screen.ACTIVITY_LIST.name) {
                ActivityRoute(
                    categories = viewModel.getCategories(),
                    categorySelect = { selectedCategory ->
                        viewModel.updateCategory(selectedCategory)
                    },
                    activities = viewModel.getCurrentActivities(),
                    activitySelect = { selectedActivity ->
                        viewModel.updateActivity(selectedActivity)
                        viewModel.updateIsNavBackward(isNavBackward = false)
                        navController.navigate(Screen.ACTIVITY_DETAILS.name)
                    },
                    selectedActivity = viewModel.getCurrentActivity(),
                    onBackPress = {navigateBack()},
                    isExpandedScreen = isExpandedScreen,
                    isNavBackward = viewModel.isNavBackward()
                )
            }
            composable(route = Screen.ACTIVITY_DETAILS.name) {
                ActivityDetailsRoute(
                    activities = viewModel.getCurrentActivities(),
                    activitySelect = { selectedActivity ->
                        viewModel.updateActivity(selectedActivity) },
                    selectedActivity = viewModel.getCurrentActivity(),
                    onBackPress = {navigateBack()},
                    isExpandedScreen = isExpandedScreen
                )
            }
        }
    }
}