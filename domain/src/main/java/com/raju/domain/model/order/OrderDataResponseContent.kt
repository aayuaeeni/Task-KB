package com.raju.domain.model.order

data class OrderDataResponseContent(
    val `data`: OrderDataContent,
    val status: StatusContent
)