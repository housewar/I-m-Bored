package com.example.imbored.ui.util

import androidx.annotation.StringRes
import com.example.imbored.R

enum class Screen(@StringRes val title: Int) {
    CATEGORY_LIST(title = R.string.category),
    ACTIVITY_LIST(title = R.string.activity),
    ACTIVITY_DETAILS(title = R.string.details)
}