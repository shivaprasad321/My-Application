package com.shivaprasad.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val repository: Repository, private val api : API, private val activity: MainActivity): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelData::class.java!!)) {
            ViewModelData(this.api,this.repository,this.activity) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}