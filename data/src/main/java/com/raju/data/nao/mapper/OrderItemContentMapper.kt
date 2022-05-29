package com.raju.data.nao.mapper

import com.raju.data.nao.order.OrderItem
import com.raju.domain.model.order.OrderItemContent
import com.raju.domain.parseProtection
import javax.inject.Inject

class OrderItemContentMapper @Inject constructor(){
    fun map(it: OrderItem): OrderItemContent? {
        return parseProtection {
            OrderItemContent(
                it.itemId,
                it.itemImgUrl,
                it.itemName,
                it.orderId,
                it.price,
                it.quantity,
                it.status,
                it.totalItemAmount,
                it.userId
            )
        }
    }
}