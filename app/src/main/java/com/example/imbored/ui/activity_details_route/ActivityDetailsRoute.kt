package com.example.imbored.ui.activity_details_route

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imbored.model.Activity
import com.example.imbored.ui.BoredViewModel
import com.example.imbored.ui.activity_details_screen.ActivityDetails
import com.example.imbored.ui.activity_list_screen.ActivityList

@Composable
fun ActivityDetailsRoute(
    activities: List<Activity>,
    activitySelect: (Activity) -> Unit,
    selectedActivity: Activity,
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit = {},
    isExpandedScreen: Boolean = false,
) {
    Row(modifier = modifier){
        if (isExpandedScreen){
            ActivityList(
                activities = activities,
                activitySelect = activitySelect,
                modifier = Modifier.weight(1f),
                onBackPress = onBackPress
            )
        }
        ActivityDetails(
            selectedActivity = selectedActivity,
            modifier = Modifier.weight(1f),
            onBackPress = onBackPress
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun ActivityDetailsRoutePreview(){
    val viewModel: BoredViewModel = viewModel()
    ActivityDetailsRoute(
        activities = viewModel.getCurrentActivities(),
        activitySelect = {},
        selectedActivity = viewModel.getCurrentActivity(),
        isExpandedScreen = true
    )
}