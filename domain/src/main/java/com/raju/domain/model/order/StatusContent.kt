package com.raju.domain.model.order


data class StatusContent(
    val httpCode: String,
    val message: String,
    val success: Boolean
)