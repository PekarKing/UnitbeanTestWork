package com.android.unitbeantestwork.other

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fact {

    @SerializedName("_id")
    @Expose
    var id = ""
        get() = field
        set(value) {
            field = value
        }

    var factNumber = ""
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("text")
    @Expose
    var text = ""
        get() = field
        set(value) {
            field = value
        }

    var createdAt = ""
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("upvotes")
    @Expose
    var upVotes = 0
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("user")
    @Expose
    var user = User(Name("", ""))
        get() = field
        set(value) {
            field = value
        }

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
}

class User(name: Name) {
    @SerializedName("name")
    @Expose
    var name = name
        get() = field
        set(value) { field = value }
}

class Name(first: String, last: String) {
    @SerializedName("first")
    @Expose
    var first = first
        get() = field
        set(value) { field = value }

    @SerializedName("last")
    @Expose
    var last = last
        get() = field
        set(value) { field = value }
}