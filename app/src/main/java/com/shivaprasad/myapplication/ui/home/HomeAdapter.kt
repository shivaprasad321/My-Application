package com.shivaprasad.myapplication.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shivaprasad.myapplication.BR
import com.shivaprasad.myapplication.data.model.ResponceData.*
import java.util.*
import kotlin.collections.ArrayList


class HomeAdapter (@LayoutRes val layoutID : Int, var data : ArrayList<ResponceArray>, private val viewmodel : HomeViewModel, val activity: HomeActivity) :
    RecyclerView.Adapter<HomeAdapter.GenericViewModel>() {

     var copydata: ArrayList<ResponceArray> = ArrayList()


    class GenericViewModel (private var binding : ViewDataBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(viewmodel: HomeViewModel, position:Int, activity: HomeActivity){

            binding.setVariable(BR.layoutposision,position)
            binding.setVariable(BR.itemviewModel,viewmodel)
            binding.setVariable(BR.activity,activity)
            binding.setVariable(BR.setselected,true)

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
        return data.size
    }


    override fun onBindViewHolder(holder: GenericViewModel, position: Int) {
        holder.bind(viewmodel,position,activity)
    }


    override fun getItemViewType(position: Int): Int {
        return layoutID
    }

    fun dataupdate( updatedData : ArrayList<ResponceArray>){
       this .data  =  updatedData
        notifyDataSetChanged()

        for (setdata in data) {
            this.copydata.add(setdata.copy())
        }

    }

    fun filter(queryText: String) {
        data.clear()
        if (queryText.isEmpty()) {
            data.addAll(copydata)
        } else {
            for (track in copydata) {
                if (track.artistName?.toLowerCase(Locale.ROOT)?.contains(queryText.toLowerCase())!!) {
                    data.add(track)
                }
            }
        }
        notifyDataSetChanged()
    }


}