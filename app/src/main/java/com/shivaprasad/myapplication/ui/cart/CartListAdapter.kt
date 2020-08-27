package com.shivaprasad.myapplication.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shivaprasad.myapplication.BR
import com.shivaprasad.myapplication.data.model.ResponceData
import kotlin.collections.ArrayList

class CartListAdapter (@LayoutRes val layoutID : Int, var cartdata : ArrayList<ResponceData.ResponceArray>, private val viewmodel : CartViewModel, val activity: CartListActivity) :
    RecyclerView.Adapter<CartListAdapter.GenericViewModel>() {



    class GenericViewModel (private var binding : ViewDataBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(viewmodel: CartViewModel, position:Int, activity: CartListActivity, cartdata: ArrayList<ResponceData.ResponceArray>){

            binding.setVariable(BR.layoutposision,position)
            binding.setVariable(BR.cartViewModel,viewmodel)
            binding.setVariable(BR.activity,activity)
            binding.setVariable(BR.setselected,true)
            binding.setVariable(BR.data, cartdata[position])


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewModel {
        val layoutInflarter = LayoutInflater.from(parent.context)
        val  binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflarter,viewType,parent,false)

        return GenericViewModel(
            binding
        )
    }

    override fun getItemCount(): Int {
        return cartdata.size
    }


    override fun onBindViewHolder(holder: GenericViewModel, position: Int) {
        holder.bind(viewmodel,position,activity,cartdata)
    }


    override fun getItemViewType(position: Int): Int {
        return layoutID
    }

    fun dataupdate( updatedData : ArrayList<ResponceData.ResponceArray>){
        this .cartdata  =  updatedData
        notifyDataSetChanged()



    }

}