package com.android.unitbeantestwork.internet

import com.android.unitbeantestwork.other.Fact
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("facts")
    fun getAllFacts(): Call<FactList>

//    @GET("facts")
//    fun getFactById(@Query("_id") _id: String): Call<Fact>

    class FactList(facts: List<Fact>) {
        @SerializedName("all")
        @Expose
        val facts = facts
            get() = field
    }

}