package com.shivaprasad.myapplication.ui.cart

import android.view.View
import androidx.lifecycle.ViewModel
import com.shivaprasad.myapplication.R
import com.shivaprasad.myapplication.data.model.ResponceData

class CartViewModel (val activity: CartListActivity, var data : ArrayList<ResponceData.ResponceArray>): ViewModel() {

    var adapter = CartListAdapter(
        R.layout.cart_list_item,
        data,
        this,
        activity
    )

    fun setAdapter(): CartListAdapter {
        return adapter
    }


    fun setListpositionvalue(position: Int): ResponceData.ResponceArray {
        return data[position]
    }

    fun onBackbuttonClick(view : View){

        activity.finish()

    }


}