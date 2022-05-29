package com.raju.data.nao.mapper

import com.raju.data.nao.order.OrdersResponseDTO
import com.raju.data.nao.order.Status
import com.raju.domain.model.order.OrdersResponseDTOContent
import com.raju.domain.model.order.StatusContent
import com.raju.domain.parseProtection
import javax.inject.Inject

class OrderResponseDTOContentMapper@Inject constructor(private val orderItemContentMapper: OrderItemContentMapper,
) {
    fun map(it: OrdersResponseDTO): OrdersResponseDTOContent? {
        return parseProtection {
            OrdersResponseDTOContent(
                it.createdAt,
                it.orderId,
                it.orderItems.mapNotNull { orderItems -> orderItemContentMapper.map(orderItems) },
                it.quantity,
                it.status,
                it.userId
            )
        }
    }
}