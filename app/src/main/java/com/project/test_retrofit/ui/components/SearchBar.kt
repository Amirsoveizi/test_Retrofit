package com.project.test_retrofit.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MySearchBar(
    modifier: Modifier = Modifier,
    onSearch: () -> Unit,
    query : StateFlow<String>,
    onQueryChange: (String) -> Unit
){
  Card(
      modifier = modifier
          .padding(5.dp)
          .fillMaxWidth()
          .height(40.dp),
      colors = CardDefaults.cardColors(
          containerColor = MaterialTheme.colorScheme.secondaryContainer
      )
  ) {
      Row(
          modifier = modifier
              .padding(5.dp),
          verticalAlignment = Alignment.CenterVertically
      ) {
          BasicTextField(
              value = query.collectAsState().value,
              onValueChange = onQueryChange,
              modifier = modifier
                  .fillMaxWidth()
                  .weight(10f),
              maxLines = 1,
              singleLine = true,
              textStyle = MaterialTheme.typography.titleMedium
          )
          IconButton(
              onClick = onSearch,
              modifier = modifier
                  .fillMaxWidth()
                  .weight(1f)
          ) {
              Icon(
                  imageVector = Icons.Default.Search,
                  contentDescription = null
              )
          }
      }
  }
}


//@Preview
//@Composable
//private fun MySearchBarPreview() {
//    Test_RetrofitTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Scaffold() {
//                Column(
//                    modifier = Modifier
//                        .padding(it)
//                        .fillMaxSize()
//                ) {
//                    MySearchBar(
//                        onSearch = {}
//                    )
//                }
//            }
//        }
//    }
//}