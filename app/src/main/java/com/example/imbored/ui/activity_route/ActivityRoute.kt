package com.example.imbored.ui.activity_route

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imbored.model.Activity
import com.example.imbored.model.Category
import com.example.imbored.ui.BoredViewModel
import com.example.imbored.ui.activity_details_screen.ActivityDetails
import com.example.imbored.ui.activity_list_screen.ActivityList
import com.example.imbored.ui.category_list_screen.CategoryList

@Composable
fun ActivityRoute(
    categories: List<Category>,
    categorySelect: (Category) -> Unit,
    activities: List<Activity>,
    activitySelect: (Activity) -> Unit,
    selectedActivity: Activity,
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit = {},
    isExpandedScreen: Boolean = false,
    isNavBackward: Boolean = false
) {
    Row(modifier = modifier){

        if (isExpandedScreen && isNavBackward){
            CategoryList(
                categories = categories,
                categorySelect = categorySelect,
                modifier = Modifier.weight(1f),
                onBackPress = onBackPress)
        }

        ActivityList(
            activities = activities,
            activitySelect = activitySelect,
            modifier = Modifier.weight(1f),
            onBackPress = onBackPress)

        if (isExpandedScreen && !isNavBackward){
            ActivityDetails(
                selectedActivity = selectedActivity,
                modifier = Modifier.weight(1f),
                onBackPress = onBackPress)
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun ActivityRoutePreview(){
    val viewModel: BoredViewModel = viewModel()
    ActivityRoute(
        categories = viewModel.getCategories(),
        categorySelect = {},
        activities = viewModel.getCurrentActivities(),
        activitySelect = {},
        selectedActivity = viewModel.getCurrentActivity(),
        isExpandedScreen = true,
    )
}