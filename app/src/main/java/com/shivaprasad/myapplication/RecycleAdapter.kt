package com.shivaprasad.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter (@LayoutRes val layoutID : Int, var dataStore : ResponceData.Responce, private val viewmodel : ViewModelData, val activity: MainActivity) :
    RecyclerView.Adapter<RecycleAdapter.GenericViewModel>() {

    var data = this.dataStore.copy()


    class GenericViewModel (private var binding : ViewDataBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(viewmodel: ViewModelData, position:Int,activity:MainActivity){

            binding.setVariable(BR.layoutposision,position)
            binding.setVariable(BR.itemviewModel,viewmodel)
            binding.setVariable(BR.activity,activity)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleAdapter.GenericViewModel {
        val layoutInflarter = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflarter,viewType,parent,false)

        return GenericViewModel(binding)
    }

    override fun getItemCount(): Int {
        return dataStore.results.size
    }


    override fun onBindViewHolder(holder: GenericViewModel, position: Int) {
        holder.bind(viewmodel,position,activity)
    }


    override fun getItemViewType(position: Int): Int {
        return layoutID
    }

    fun dataupdate( updatedData : ResponceData.Responce){
       this .dataStore  =  updatedData
        notifyDataSetChanged()

    }

    fun filter(text: String?) {
        val temp: MutableList<ResponceData.ResponceArray> = ArrayList()
        if (text != null) {

                for (d in dataStore.results) {
                    //or use .equal(text) with you want equal match
                    //use .toLowerCase() for better matches
                    if (d.trackName.contains(text.toString()) ||
                        d.artistName.contains(text.toString())) {
                        temp.add(d)
                    }
                }
                //update recyclerview
                dataStore.results.clear()
                dataStore.results.addAll(temp)
                dataupdate(dataStore)

                   }
    }
}