package com.raju.data.nao.order


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.raju.domain.model.order.OrdersResponseDTOContent
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderDataNao(
    @SerializedName("ordersResponseDTO")
    val ordersResponseDTO: List<OrdersResponseDTO>,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Int
):Parcelable