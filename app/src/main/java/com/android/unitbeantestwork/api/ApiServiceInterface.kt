package com.android.unitbeantestwork.api

import com.android.unitbeantestwork.mvp.model.Fact
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {
    class FactList(@SerializedName("all") @Expose val facts: List<Fact>)

    class SpecialFact(@SerializedName("text") @Expose val text: String,
                      @SerializedName("createdAt") @Expose val createdAt: String)

    @GET("facts")
    fun getAllFacts(): Observable<FactList>

    @GET("facts/{id}")
    fun getFactById(@Path("id") id: String): Observable<SpecialFact>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://cat-fact.herokuapp.com/")
                .build()
            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}