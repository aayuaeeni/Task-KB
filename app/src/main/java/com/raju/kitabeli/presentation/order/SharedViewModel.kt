package com.raju.kitabeli.presentation.order

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raju.kitabeli.bean.order.RequestBean
import dagger.hilt.android.lifecycle.HiltViewModel

class SharedViewModel  : ViewModel() {
    val requestLD = MutableLiveData<RequestBean>()

    fun sendRequestData(requestBean: RequestBean) {
        requestLD.value = requestBean
    }
}