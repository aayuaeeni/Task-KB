package com.raju.kitabeli.mapper

import com.raju.domain.model.order.StatusContent
import com.raju.domain.parseProtection
import com.raju.kitabeli.bean.order.StatusBean
import javax.inject.Inject

class StatusBeanMapper @Inject constructor() {
    fun map(it: StatusContent): StatusBean? {
        return parseProtection {
            StatusBean(
                it.httpCode,
                it.message,
                it.success,
            )
        }
    }
}