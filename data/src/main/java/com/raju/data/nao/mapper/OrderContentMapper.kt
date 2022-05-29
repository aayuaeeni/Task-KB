package com.raju.data.nao.mapper

import com.raju.data.nao.order.OrderDataNao
import com.raju.domain.model.order.OrderDataContent
import com.raju.domain.parseProtection
import javax.inject.Inject

class OrderContentMapper @Inject constructor(private val orderResponseDTOContentMapper:OrderResponseDTOContentMapper) {
    fun map(it: OrderDataNao): OrderDataContent {
        return parseProtection {
            OrderDataContent(
                it.ordersResponseDTO.mapNotNull { orderItems -> orderResponseDTOContentMapper.map(
                    orderItems
                ) },
                it.totalItems,
                it.totalPages
            )
        }!!

    }
}