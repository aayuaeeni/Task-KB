package com.raju.kitabeli.mapper

import com.raju.domain.model.order.OrderDataResponseContent
import com.raju.domain.parseProtection
import com.raju.kitabeli.bean.order.OrderDataResponseBean
import javax.inject.Inject

class OrderDataResponseBeanMapper @Inject constructor(private val orderContentMapper: OrderDataBeanMapper, private val statusContentMapper: StatusBeanMapper
) {
    fun map(it: OrderDataResponseContent): OrderDataResponseBean {
        return parseProtection {
            OrderDataResponseBean(
                orderContentMapper.map(it.data),
                statusContentMapper.map(it.status)!!
            )
        }!!
    }
}