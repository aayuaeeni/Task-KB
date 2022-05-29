package com.raju.data.nao.order


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderDataResponseNao(
    @SerializedName("data")
    val `data`: OrderDataNao,
    @SerializedName("status")
    val status: Status
):Parcelable