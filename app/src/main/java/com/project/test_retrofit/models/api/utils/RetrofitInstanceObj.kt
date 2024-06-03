package com.project.test_retrofit.models.api.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceObj {
    val dummyJsonApi : DummyJsonApi by lazy {
        Retrofit.Builder()
            .baseUrl(dummyJsonUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DummyJsonApi::class.java)
    }
}