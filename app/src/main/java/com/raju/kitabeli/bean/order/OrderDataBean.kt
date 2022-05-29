package com.raju.kitabeli.bean.order

data class OrderDataBean(
    val ordersResponseDTO: List<OrdersResponseDTOBean>,
    val totalItems: Int,
    val totalPages: Int
)