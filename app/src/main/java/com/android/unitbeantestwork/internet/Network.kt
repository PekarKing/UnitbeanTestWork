package com.android.unitbeantestwork.internet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    private val url = "https://cat-fact.herokuapp.com/"
    private var mRetrofit: Retrofit

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getAPI(): NetworkApi {
        return mRetrofit.create(NetworkApi::class.java)
    }
}