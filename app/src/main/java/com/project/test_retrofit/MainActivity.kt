package com.project.test_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.test_retrofit.models.MyViewModel
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

                    LaunchedEffect(key1 = Unit) {

//                        val x = RetrofitInstanceObj.api.getProducts()
//                        Log.d(TAG, "x : ${x.body()?.skip}")
//
//                        val item = RetrofitInstanceObj.api.getProduct(5)
//                        Log.d(TAG, "item : ${item.body()?.title}")
//
//                        val all = RetrofitInstanceObj.api.getCategoriesList()
//                        all.body()?.forEach {
//                            Log.d(TAG, "all : $it")
//                        }
//
//
//                        //10 last items
//                        val map = HashMap<String, String>()
//                        map["limit"] = "10"
//                        map["sortBy"] = "id"
//                        map["order"] = "desc"
//                        val get = RetrofitInstanceObj.api.getProducts(options = map)
//                        get.body()?.products?.forEach {
//                            Log.d(TAG, "id : ${it.id}")
//                        }

                    }

                }
            }
        }
    }
}
