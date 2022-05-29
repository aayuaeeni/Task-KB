package com.raju.data.nao.mapper

import com.raju.data.nao.order.Status
import com.raju.domain.model.order.StatusContent
import com.raju.domain.parseProtection
import javax.inject.Inject

class StatusContentMapper @Inject constructor() {
    fun map(it: Status): StatusContent? {
        return parseProtection {
            StatusContent(
                it.httpCode,
                it.message,
                it.success,
            )
        }
    }
}