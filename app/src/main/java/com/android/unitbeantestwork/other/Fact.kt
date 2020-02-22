package com.android.unitbeantestwork.other

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

class Fact(_id: String, _v: Int, user: String, text: String, updatedAt: Timestamp, sendDate: Timestamp,
           deleted: Boolean, source: String, used: Boolean, type: String) {
    @SerializedName("_id")
    @Expose
    var id = _id
        get() = field
        set(value) { field = value }

    @SerializedName("_v")
    @Expose
    var v = _v
        get() = field
        set(value) { field = value }

    @SerializedName("user")
    @Expose
    var user = user
        get() = field
        set(value) { field = value }

    @SerializedName("text")
    @Expose
    var text = text
        get() = field
        set(value) { field = value }

    @SerializedName("updatedAt")
    @Expose
    var updatedAt = updatedAt
        get() = field
        set(value) { field = value }

    @SerializedName("sendDate")
    @Expose
    var sendDate = sendDate
        get() = field
        set(value) { field = value }

    @SerializedName("deleted")
    @Expose
    var deleted = deleted
        get() = field
        set(value) { field = value }

    @SerializedName("source")
    @Expose
    var source = source
        get() = field
        set(value) { field = value }

    @SerializedName("used")
    @Expose
    var used = used
        get() = field
        set(value) { field = value }

    @SerializedName("type")
    @Expose
    var type = type
        get() = field
        set(value) { field = value }
}