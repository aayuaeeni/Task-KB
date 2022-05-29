package com.raju.kitabeli.bean.order


data class RequestBean(
    var userId: String ,
    var status: String,
    var page: Int ,
    var size: Int
)