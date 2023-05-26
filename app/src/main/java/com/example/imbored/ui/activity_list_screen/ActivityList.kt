package com.example.imbored.ui.activity_list_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imbored.model.Activity
import com.example.imbored.ui.BoredViewModel
import com.example.imbored.ui.activity_list_screen.components.ActivityListItem

@Composable
fun ActivityList(
    activities: List<Activity>,
    activitySelect: (Activity) -> Unit,
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit = {}
){
    BackHandler {
        onBackPress()
    }
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(activities, key = {activity -> activity.name}) { activity ->
            ActivityListItem(
                activity = activity,
                activitySelect = activitySelect
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityListPreview(){
    val viewModel:BoredViewModel = viewModel()
    ActivityList(
        activities = viewModel.getCurrentActivities(),
        activitySelect = {}
    )
}