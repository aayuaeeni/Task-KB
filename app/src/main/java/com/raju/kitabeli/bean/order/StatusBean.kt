package com.raju.kitabeli.bean.order


data class StatusBean(
    val httpCode: String,
    val message: String,
    val success: Boolean
)