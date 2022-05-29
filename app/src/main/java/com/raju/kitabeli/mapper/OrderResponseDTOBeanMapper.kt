package com.raju.kitabeli.mapper

import com.raju.domain.model.order.OrdersResponseDTOContent
import com.raju.domain.parseProtection
import com.raju.kitabeli.bean.order.OrdersResponseDTOBean
import javax.inject.Inject

class OrderResponseDTOBeanMapper@Inject constructor(private val orderItemContentMapper: OrderItemBeanMapper,
) {
    fun map(it: OrdersResponseDTOContent): OrdersResponseDTOBean? {
        return parseProtection {
            OrdersResponseDTOBean(
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