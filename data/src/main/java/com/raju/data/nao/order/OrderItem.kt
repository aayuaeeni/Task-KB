package com.raju.data.nao.order


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("isDailyDealItem")
    val isDailyDealItem: Boolean,
    @SerializedName("isItemGroupItem")
    val isItemGroupItem: Boolean,
    @SerializedName("itemId")
    val itemId: Int,
    @SerializedName("itemImgUrl")
    val itemImgUrl: String,
    @SerializedName("itemName")
    val itemName: String,
    @SerializedName("orderId")
    val orderId: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalItemAmount")
    val totalItemAmount: Int,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userId")
    val userId: Int
):Parcelable