package com.raju.domain.model.order

data class OrdersResponseDTOContent(
    val createdAt: String,
    val orderId: Int,
    val orderItems: List<OrderItemContent>,
    val quantity: Int,
    val status: String,
    val userId: Int
){

}