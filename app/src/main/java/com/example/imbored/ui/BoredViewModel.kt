package com.example.imbored.ui

import androidx.lifecycle.ViewModel
import com.example.imbored.data.DataSource
import com.example.imbored.model.Category
import com.example.imbored.model.Activity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class BoredViewModel : ViewModel() {
    private val _state = MutableStateFlow(
        BoredUiState()
    )
    val state: StateFlow<BoredUiState> = _state

    fun updateCategory(selectedCategory: Category){
        _state.update {
            it.copy(
                category = selectedCategory,
                activity = getActivities(selectedCategory).first()
            )
        }
    }

    fun updateActivity(selectedActivity: Activity){
        _state.update {
            it.copy(
                category = selectedActivity.category,
                activity = selectedActivity
            )
        }
    }

    fun updateLastScreen(screenName: String){
        _state.update {
            it.copy(
                lastScreen = screenName
            )
        }
    }

    fun getCategories() : List<Category> {
        return DataSource.categories
    }

    private fun getActivities(selectedCategory: Category) : List<Activity> {
        return DataSource.activities.filter {
            it.category.name == selectedCategory.name
        }
    }

    fun getCurrentActivities() : List<Activity> {
        return DataSource.activities.filter {
            it.category.name == _state.value.category.name
        }
    }
    fun getLastScreen(): String {
        return _state.value.lastScreen
    }

    fun getCurrentCategory() : Category {
        return _state.value.category
    }
    fun getCurrentActivity() : Activity {
        return _state.value.activity
    }
}