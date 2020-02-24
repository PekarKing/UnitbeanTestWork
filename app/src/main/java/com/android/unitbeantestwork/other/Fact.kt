package com.android.unitbeantestwork.other

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fact(_id: String, user: User, text: String, /*createdAt: String?,*/ upVotes: Int) {

    @SerializedName("_id")
    @Expose
    var id = _id
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("text")
    @Expose
    var text = text
        get() = field
        set(value) {
            field = value
        }

//    @SerializedName("createdAt")
//    @Expose
//    var createdAt = createdAt
////    var createdAt = "11.12.2020 16:00"
//        get() = field
//        set(value) {
//            field = value
//        }

    @SerializedName("upvotes")
    @Expose
    var upVotes = upVotes
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("user")
    @Expose
    var user = user
        get() = field
        set(value) {
            field = value
        }
}

class User(_id: String, name: Name) {
    @SerializedName("_id")
    @Expose
    var id = _id
        get() = field
        set(value) { field = value }

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