package com.project.test_retrofit.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.test_retrofit.models.MyViewModel

@Composable
fun MainScreen(
    modifier : Modifier = Modifier,
    vm : MyViewModel
){
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            MyTopBar(

            )
        },
        bottomBar = {
            MyBottomBar(

            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            MySearchBar(
                modifier = modifier,
                onSearch = {
                           vm.searchProducts()
                },
                onQueryChange = vm.onQueryChange,
                query = vm.query
            )

            when(vm.isDataLoaded.collectAsState().value){
                true -> {
                    when(vm.getResult()?.total){
                        0 -> {
                            Box(
                                modifier = modifier
                                    .fillMaxSize()
                            ){
                                Text(
                                    text = "No products found",
                                    modifier = modifier.align(Alignment.Center)
                                )
                            }
                        }
                        else -> {
                            LazyColumn(
                                modifier = modifier
                                    .fillMaxSize()
                            ) {
                                items(vm.getResult()?.products!!){ product ->
                                    ItemCardHorizontal(item = product)
                                }
                            }
                        }
                    }
                }
                false -> {
                    Box(
                        modifier = modifier
                            .fillMaxSize()
                    ){
                        CircularProgressIndicator(
                            modifier = modifier
//                                .matchParentSize(),
                                .align(Alignment.Center),
                            strokeWidth = 6.dp
                        )
                    }
                }
            }
        }
    }
}