package com.raju.kitabeli.bean.order

data class OrderItemBean(
    val itemId: Int,
    val itemImgUrl: String,
    val itemName: String,
    val orderId: Int,
    val price: Int,
    val quantity: Int,
    val status: String,
    val totalItemAmount: Int,
    val userId: Int
)