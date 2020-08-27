package com.shivaprasad.myapplication.ui.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivaprasad.myapplication.R
import com.shivaprasad.myapplication.data.model.ResponceData.*
import com.shivaprasad.myapplication.databinding.ActivityCartListBinding

class CartListActivity : AppCompatActivity() {

    lateinit var activityCartListBinding: ActivityCartListBinding
    lateinit var data: ArrayList<ResponceArray>
    lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityCartListBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_cart_list
        )

        if(intent.extras != null) {
            data = intent.getSerializableExtra("cartData") as ArrayList<ResponceArray>


        }

        cartViewModel = ViewModelProvider(this,
            CartViewModelFatory(data, this)
        ).get(CartViewModel::class.java)

        activityCartListBinding.listrecycleview.layoutManager = LinearLayoutManager(this)

        activityCartListBinding.cartViewModel = cartViewModel
        activityCartListBinding.activity = this

        cartViewModel.adapter.dataupdate(data)
    }

}