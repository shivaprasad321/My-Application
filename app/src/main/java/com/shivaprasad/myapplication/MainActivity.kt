package com.shivaprasad.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivaprasad.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModelData: ViewModelData
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var  api : API
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        api = API()
        repository = Repository(api)

        viewModelData = ViewModelProvider(this,ViewModelFactory(repository,api,this)).get(ViewModelData::class.java)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        activityMainBinding.viewModel = viewModelData
        activityMainBinding.lifecycleOwner = this

        activityMainBinding.listrecycleview.layoutManager = LinearLayoutManager(this)

        viewModelData.updateData()


    }
}
