package com.raju.domain.repository

import com.raju.domain.model.order.OrderDataResponseContent
import io.reactivex.rxjava3.core.Observable

interface OrderRepository {
    fun getOrders(
        userId: String,
        status: String,
        page: Int,
        size: Int
    ): Observable<OrderDataResponseContent>

}