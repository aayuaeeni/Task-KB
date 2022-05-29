package com.raju.kitabeli.presentation.order

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raju.domain.model.order.OrdersResponseDTOContent
import com.raju.domain.usecase.OrderUseCase
import com.raju.kitabeli.bean.order.OrdersResponseDTOBean
import com.raju.kitabeli.bean.order.RequestBean
import com.raju.kitabeli.mapper.OrderDataResponseBeanMapper
import com.raju.kitabeli.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderUseCase: OrderUseCase,
    private val orderDataResponseBeanMapper: OrderDataResponseBeanMapper,

    ) : BaseViewModel() {

    private val _orderListLD: MutableLiveData<List<OrdersResponseDTOBean>> = MutableLiveData()
    val orderListLD: LiveData<List<OrdersResponseDTOBean>>
        get() = _orderListLD

    private val _noItemLD: MutableLiveData<Boolean> = MutableLiveData()
    val noItemLD: LiveData<Boolean>
        get() = _noItemLD

    fun onViewCreated(
        requestBean: RequestBean
    ) {
        getOrders(requestBean.userId,requestBean.status,requestBean.page,requestBean.size)
    }

    private fun getOrders(userId: String,
                          status: String,
                          page: Int,
                          size: Int) {
        orderUseCase.getOrders(userId,status,page,size).map {
            orderDataResponseBeanMapper.map(it)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.status.success){
                    _orderListLD.postValue(it.data.ordersResponseDTO)
                }else{
                    _noItemLD.postValue(it.status?.success)
                }
            }, {
                Log.d("raju",it.message.toString())
            })
    }

}