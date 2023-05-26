package com.example.imbored.model

import androidx.annotation.DrawableRes

data class Activity(
    val category: Category,
    val name: String,
    @DrawableRes val imageID: Int,
    val description: String
)