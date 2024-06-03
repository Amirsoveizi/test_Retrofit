package com.project.test_retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.test_retrofit.models.MyViewModel
import com.project.test_retrofit.models.api.utils.RetrofitInstanceObj
import com.project.test_retrofit.ui.components.ItemCardHorizontal
import com.project.test_retrofit.ui.components.MainScreen
import com.project.test_retrofit.ui.theme.Test_RetrofitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<MyViewModel>()
            val modifier = Modifier

            Test_RetrofitTheme {
                Surface(
                    modifier = modifier.fillMaxSize(),
                ) {
                    MainScreen(
                        modifier = modifier,
                        vm = viewModel
                    )
                }
            }
        }
    }
}
