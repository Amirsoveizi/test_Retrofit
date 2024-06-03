package com.project.test_retrofit.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.project.test_retrofit.models.api.product.Product

@Composable
fun ItemCardHorizontal(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(5.dp),
    item: Product
){
    ElevatedCard(
        modifier = modifier
            .padding(paddingValues),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .height(150.dp),
        ) {
            SubcomposeAsyncImage(
                model = item.thumbnail,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .border(0.3.dp, MaterialTheme.colorScheme.primary),
                loading = {
                    CircularProgressIndicator()
                },
                error = {
                    Icon(imageVector = Icons.Filled.Close, contentDescription = null)
                },
            )
            Spacer(modifier = modifier.width(5.dp))
            Text(text = "title : \n${item.title}", fontSize = 14.sp)
        }
    }
}