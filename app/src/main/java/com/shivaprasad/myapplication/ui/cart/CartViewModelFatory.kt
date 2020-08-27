package com.shivaprasad.myapplication.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shivaprasad.myapplication.data.model.ResponceData

class CartViewModelFatory(private val data: ArrayList<ResponceData.ResponceArray>, private val activity: CartListActivity): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CartViewModel::class.java!!)) {
            CartViewModel(
                this.activity,
                this.data
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}