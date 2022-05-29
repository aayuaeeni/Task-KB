package com.raju.data.repository

import com.raju.data.nao.mapper.OrderDataResponseContentMapper
import com.raju.data.network.KitaBeliApiInterface
import com.raju.data.utils.makeApiRequest
import com.raju.domain.model.order.OrderDataResponseContent
import com.raju.domain.repository.OrderRepository
import com.raju.utils.onErrorObservable
import com.raju.utils.onSuccessObservable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Named

class OrderDataRepository @Inject constructor(
    @Named("api") private val kitaBeliApiInterface: KitaBeliApiInterface,
    private val orderDataResponseContentMapper: OrderDataResponseContentMapper,
    ) : OrderRepository {

    override fun getOrders(
        userId: String,
        status: String,
        page: Int,
        size: Int
    ): Observable<OrderDataResponseContent> {
        return makeApiRequest(kitaBeliApiInterface.getOrders(
            userId, status,page,size
        ), { emitter, it ->
            if (!it.status.success) {
                emitter.onErrorObservable(Throwable(message = "Server Error!"))
            } else {
                orderDataResponseContentMapper.map(it)
            }
        }, { emitter, it ->
            if (it is OrderDataResponseContent) emitter.onSuccessObservable(it)
        })
    }
}