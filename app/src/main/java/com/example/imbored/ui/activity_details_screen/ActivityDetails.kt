package com.example.imbored.ui.activity_details_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imbored.model.Activity
import com.example.imbored.ui.BoredViewModel

@Composable
fun ActivityDetails(
    selectedActivity: Activity,
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit = {}
) {
    BackHandler {
        onBackPress()
    }
    val scrollState = rememberScrollState()
    Box(
        modifier = modifier
            .verticalScroll(state = scrollState),
    ) {
        Column {
            Box {
                Box() {
                    Image(
                        painter = painterResource(selectedActivity.imageID),
                        contentDescription = null,
                        //alignment = Alignment.TopCenter,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
                Column(
                    Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Transparent, MaterialTheme.colorScheme.scrim),
                                0f,
                                400f
                            )
                        )
                ) {
                    Text(
                        text = selectedActivity.name,
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
                }
            }
            Text(
                text = selectedActivity.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    vertical = 24.dp,
                    horizontal = 40.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ActivityDetailsPreview(){
    val viewModel:BoredViewModel = viewModel()
    ActivityDetails(
        selectedActivity = viewModel.getCurrentActivity()
    )
}