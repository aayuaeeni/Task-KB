package com.raju.kitabeli.mapper

import com.raju.domain.model.order.OrderItemContent
import com.raju.domain.parseProtection
import com.raju.kitabeli.bean.order.OrderItemBean
import javax.inject.Inject

class OrderItemBeanMapper @Inject constructor(){
    fun map(it: OrderItemContent): OrderItemBean? {
        return parseProtection {
            OrderItemBean(
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