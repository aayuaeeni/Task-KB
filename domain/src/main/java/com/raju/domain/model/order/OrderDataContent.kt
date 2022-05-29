package com.raju.domain.model.order

data class OrderDataContent(
    val ordersResponseDTO: List<OrdersResponseDTOContent>,
    val totalItems: Int,
    val totalPages: Int
)