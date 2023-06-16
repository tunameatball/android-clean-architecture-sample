package com.kkh.clean_architecture_sample.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val showToast = MutableLiveData<String>()

    fun showToast(message: String) {
        showToast.value = message
    }
}