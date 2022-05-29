package com.raju.data.nao.order


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.raju.domain.model.order.OrderItemContent
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrdersResponseDTO(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("discountAmount")
    val discountAmount: Int,
    @SerializedName("orderId")
    val orderId: Int,
    @SerializedName("orderItems")
    val orderItems: List<OrderItem>,
    @SerializedName("payerEmail")
    val payerEmail: String,
    @SerializedName("payerPhone")
    val payerPhone: String,
    @SerializedName("paymentId")
    val paymentId: Int,
    @SerializedName("paymentMode")
    val paymentMode: String,
    @SerializedName("paymentStatus")
    val paymentStatus: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("reason")
    val reason: String,
    @SerializedName("shippingCost")
    val shippingCost: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalAmount")
    val totalAmount: Int,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userId")
    val userId: Int
): Parcelable{

}