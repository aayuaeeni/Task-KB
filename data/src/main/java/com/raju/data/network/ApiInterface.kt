package com.raju.data.network

import com.raju.data.nao.order.OrderDataResponseNao
import com.raju.domain.model.order.OrderDataResponseContent
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("logistics/order")
    fun getOrders(
        @Query("userId") userId: String,
        @Query("status") status: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Observable<OrderDataResponseNao>

//    ): Observable<OrderDataResponseNao>

}