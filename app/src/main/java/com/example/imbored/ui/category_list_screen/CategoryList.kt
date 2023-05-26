package com.example.imbored.ui.category_list_screen

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
import com.example.imbored.model.Category
import com.example.imbored.ui.BoredViewModel
import com.example.imbored.ui.category_list_screen.components.CategoryListItem

@Composable
fun CategoryList(
    categories: List<Category>,
    categorySelect: (Category) -> Unit,
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
        items(categories, key = {category -> category.name}) { category ->
            CategoryListItem(
                category = category,
                onItemClick = categorySelect
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListPreview(){
    val viewModel:BoredViewModel = viewModel()
    CategoryList(
        categories = viewModel.getCategories(),
        categorySelect = {},
    )
}