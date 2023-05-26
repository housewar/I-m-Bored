package com.example.imbored.ui.category_list_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imbored.R
import com.example.imbored.data.DataSource
import com.example.imbored.model.Category

@Composable
fun CategoryListItem(
    category: Category,
    onItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.clickable { onItemClick(category) },
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoryImage(
                category = category,
                modifier = Modifier.size(dimensionResource(id = R.dimen.card_image_height)))
            Column(
                modifier = Modifier.padding(16.dp).weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text =  category.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryListItemPreview(){
    CategoryListItem(
        category = DataSource.categories[3],
        onItemClick = {}
    )
}