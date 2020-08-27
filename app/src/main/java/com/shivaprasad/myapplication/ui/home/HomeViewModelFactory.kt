package com.shivaprasad.myapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shivaprasad.myapplication.data.api.API
import com.shivaprasad.myapplication.data.api.Repository

class HomeViewModelFactory(private val repository: Repository, private val api : API, private val activity: HomeActivity): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java!!)) {
            HomeViewModel(
                this.api,
                this.repository,
                this.activity
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}