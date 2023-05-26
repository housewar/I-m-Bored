package com.example.imbored.ui

import com.example.imbored.data.DataSource
import com.example.imbored.model.Activity
import com.example.imbored.model.Category

data class BoredUiState(
    val category: Category = DataSource.activities.first().category,
    val activity: Activity = DataSource.activities.first(),
    val isNavBackward: Boolean = false
)