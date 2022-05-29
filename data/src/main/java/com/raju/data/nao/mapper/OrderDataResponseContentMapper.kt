package com.raju.data.nao.mapper

import com.raju.data.nao.order.OrderDataResponseNao
import com.raju.data.nao.order.OrdersResponseDTO
import com.raju.data.nao.order.Status
import com.raju.domain.model.order.OrderDataResponseContent
import com.raju.domain.model.order.OrdersResponseDTOContent
import com.raju.domain.model.order.StatusContent
import com.raju.domain.parseProtection
import javax.inject.Inject

class OrderDataResponseContentMapper @Inject constructor(private val orderContentMapper: OrderContentMapper, private val statusContentMapper: StatusContentMapper
) {
    fun map(it: OrderDataResponseNao): OrderDataResponseContent? {
        return parseProtection {
            OrderDataResponseContent(
                orderContentMapper.map(it.data),
                statusContentMapper.map(it.status)!!

            )
        }
    }
}