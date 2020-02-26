package com.android.unitbeantestwork.internet

import com.android.unitbeantestwork.other.Fact
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {
    @GET("facts")
    fun getAllFacts(): Call<FactList>

    @GET("facts/{id}")
    fun getFactById(@Path("id") id: String): Call<SpecialFact>
}

class FactList(facts: List<Fact>) {
    @SerializedName("all")
    @Expose
    val facts = facts
        get() = field
}

class SpecialFact {
    @SerializedName("text")
    @Expose
    var text = ""
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("createdAt")
    @Expose
    var createdAt = ""
        get() = field
        set(value) {
            field = value
        }
}