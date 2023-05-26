package com.example.imbored.ui.category_route

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imbored.model.Activity
import com.example.imbored.model.Category
import com.example.imbored.ui.BoredViewModel
import com.example.imbored.ui.activity_list_screen.ActivityList
import com.example.imbored.ui.category_list_screen.CategoryList

@Composable
fun CategoryRoute(
    categories: List<Category>,
    categorySelect: (Category) -> Unit,
    activities: List<Activity>,
    activitySelect: (Activity) -> Unit,
    isExpandedScreen: Boolean,
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit = {}
    ){
    Row(modifier = modifier){
        CategoryList(
            categories = categories,
            categorySelect = categorySelect,
            modifier = Modifier.weight(1f),
            onBackPress = onBackPress
        )
        if (isExpandedScreen) {
            ActivityList(
                activities = activities,
                activitySelect = activitySelect,
                modifier = Modifier.weight(1f),
                onBackPress = onBackPress
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun CategoryRoutePreview(){
    val viewModel: BoredViewModel = viewModel()
    CategoryRoute(
        categories = viewModel.getCategories(),
        categorySelect = {},
        activities = viewModel.getCurrentActivities(),
        activitySelect = {},
        isExpandedScreen = true
    )
}