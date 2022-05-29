package com.raju.data.nao.order


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Status(
    @SerializedName("httpCode")
    val httpCode: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
):Parcelable