package com.project.test_retrofit.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        LazyColumn(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ){

        }
    }
}