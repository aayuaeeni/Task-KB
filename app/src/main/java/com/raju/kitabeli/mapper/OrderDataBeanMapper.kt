package com.raju.kitabeli.mapper

import com.raju.domain.model.order.OrderDataContent
import com.raju.domain.parseProtection
import com.raju.kitabeli.bean.order.OrderDataBean
import javax.inject.Inject

class OrderDataBeanMapper @Inject constructor(private val orderResponseDTOContentMapper: OrderResponseDTOBeanMapper) {
    fun map(it: OrderDataContent): OrderDataBean {
        return parseProtection {
            OrderDataBean(
                it.ordersResponseDTO.mapNotNull { orderItems -> orderResponseDTOContentMapper.map(
                    orderItems
                ) },
                it.totalItems,
                it.totalPages
            )
        }!!

    }
}