package com.shivaprasad.myapplication.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivaprasad.myapplication.R
import com.shivaprasad.myapplication.data.api.API
import com.shivaprasad.myapplication.data.api.Repository
import com.shivaprasad.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var activityMainBinding: ActivityHomeBinding
    lateinit var  api : API
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        api = API()
        repository = Repository(api)

        homeViewModel = ViewModelProvider(this,
            HomeViewModelFactory(
                repository,
                api,
                this
            )
        ).get(HomeViewModel::class.java)
        activityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_home
        )

        activityMainBinding.viewModel = homeViewModel
        activityMainBinding.lifecycleOwner = this

        activityMainBinding.listrecycleview.layoutManager = LinearLayoutManager(this)

        homeViewModel.updateData()

        homeViewModel.visibility.observeForever {
            activityMainBinding.visibility = it
        }

    }
}


