package com.raju.kitabeli.bean.order

data class OrdersResponseDTOBean(
    val createdAt: String,
    val orderId: Int,
    val orderItems: List<OrderItemBean>,
    val quantity: Int,
    val status: String,
    val userId: Int
){

}