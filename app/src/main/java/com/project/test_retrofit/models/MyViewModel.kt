package com.project.test_retrofit.models


import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.test_retrofit.TAG
import com.project.test_retrofit.models.api.product.Products
import com.project.test_retrofit.models.api.utils.RetrofitInstanceObj
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel(){

    private val _isDataLoaded = MutableStateFlow(false)
    val isDataLoaded = _isDataLoaded.asStateFlow()
    private var result : Products? = null



    //search
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()
    val onQueryChange : (String) -> Unit = {
        _query.value = it
    }
    fun searchProducts(){
        viewModelScope.launch {
            _isDataLoaded.value = false
            try{
                result = RetrofitInstanceObj.dummyJsonApi.searchProducts(_query.value).body()
                if (result != null){
                    _isDataLoaded.value = true
                }
                Log.d(TAG, "result = $result")
            }catch (e : Exception){
                Log.e(TAG,"loadData() -> message=${e.message}&&cause=${e.cause}")
            }
        }
    }



    init {
        loadData()
    }

    fun getResult() : Products?{
        return result
    }


    private fun loadData(){
        viewModelScope.launch {
            try{
                result = RetrofitInstanceObj.dummyJsonApi.getProducts().body()
                if (result != null){
                    _isDataLoaded.value = true
                }
            }catch (e : Exception){
                Log.e(TAG,"loadData() -> message=${e.message}&&cause=${e.cause}")
            }
        }
    }

}