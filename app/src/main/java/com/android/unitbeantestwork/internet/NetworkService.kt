package com.android.unitbeantestwork.internet

import com.android.unitbeantestwork.MainAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService(type: Int) {
    private val BASE_URL1 = "https://jsonplaceholder.typicode.com/"
    private val BASE_URL2 = "http://www.icndb.com/api/"
    private val BASE_URL3 = "https://github.com/public-apis/public-apis#test-data/"
    private var mRetrofit: Retrofit

    init {
        var url = ""
        when (type) {
            1 -> url = BASE_URL1
            2 -> url = BASE_URL2
            3 -> url = BASE_URL3
        }
        mRetrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getAPI(): MainAPI {
        return mRetrofit.create(MainAPI::class.java)
    }
}