package com.raju.domain.usecase

import com.raju.domain.model.order.OrderDataResponseContent
import com.raju.domain.repository.OrderRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class OrderUseCase @Inject constructor(private val orderRepository: OrderRepository) {
    fun getOrders(
        userId: String,
        status: String,
        page: Int,
        size: Int
    ) : Observable<OrderDataResponseContent> = orderRepository.getOrders(
        userId,
        status,
        page,
        size,
    )
}