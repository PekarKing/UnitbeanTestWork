package com.android.unitbeantestwork.mvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fact {
    @SerializedName("_id")
    @Expose
    var id = ""
    @SerializedName("text")
    @Expose
    var text = ""
    @SerializedName("upvotes")
    @Expose
    var upVotes = 0
    @SerializedName("user")
    @Expose
    var user = User(Name("", ""))

    var factNumber = ""
    var createdAt = ""

    fun toStringArrayList(): ArrayList<String> {
        val array = ArrayList<String>()
        array.add(id)
        array.add(factNumber)
        array.add(text)
        array.add(createdAt)
        array.add(upVotes.toString())
        array.add(user.name.first)
        array.add(user.name.last)
        return array
    }

    fun toFactFromArray(array: ArrayList<String>): Fact {
        val fact = Fact()
        fact.id = array[0]
        fact.factNumber = array[1]
        fact.text = array[2]
        fact.createdAt = array[3]
        fact.upVotes = array[4].toInt()
        fact.user.name.first = array[5]
        fact.user.name.last = array[6]
        return fact
    }

    class User(@SerializedName("name") @Expose var name: Name)

    class Name(@SerializedName("first") @Expose var first: String, @SerializedName("last") @Expose var last: String)
}