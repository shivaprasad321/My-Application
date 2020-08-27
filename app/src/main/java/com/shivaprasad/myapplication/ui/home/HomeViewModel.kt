package com.shivaprasad.myapplication.ui.home

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shivaprasad.myapplication.R
import com.shivaprasad.myapplication.data.model.ResponceData.Responce
import java.util.*
import kotlin.collections.ArrayList
import com.shivaprasad.myapplication.data.model.ResponceData.*
import com.shivaprasad.myapplication.data.api.API
import com.shivaprasad.myapplication.data.api.Coroutines
import com.shivaprasad.myapplication.data.api.Repository
import com.shivaprasad.myapplication.data.model.ResponceData
import com.shivaprasad.myapplication.ui.cart.CartListActivity
import com.shivaprasad.myapplication.ui.detail.DetailsViewActivity


class HomeViewModel(val api: API, val repository: Repository, val activity: HomeActivity): ViewModel() {


    var dataFromServer : Responce = ResponceData.Responce(0, ArrayList<ResponceArray>())

    var adapter = HomeAdapter(
        R.layout.homelistitem,
        dataFromServer.results,
        this,
        activity

    )

    var visibility = MutableLiveData<Boolean>()


    fun setAdapter(): HomeAdapter {
        return adapter
    }

      fun getCheck(position: Int){

          dataFromServer.results[position].slected = dataFromServer.results[position].slected == null || dataFromServer.results[position].slected == false


    }

    fun onClick(position: Int) {
        var intent = Intent(activity, DetailsViewActivity::class.java)
            intent.putExtra("data",dataFromServer.results[position])
        activity.startActivity(intent)
    }


    fun setCheck(position: Int):Boolean{

        return !(dataFromServer.results[position].slected == null || dataFromServer.results[position].slected == false)

    }


  fun setListpositionvalue(position: Int): ResponceArray{
   return   dataFromServer.results[position]
  }

    fun updateData(){
        Coroutines.main(){

            var data = this.repository.newsdata()
            Log.d("data", data.code().toString())

            Log.d("data", data.body().toString())

            dataFromServer   = data.body()!!

            dataFromServer.results = sortedList(dataFromServer.results)


            Log.d("data", data.message())

            Log.d("data", data.raw().toString())

            adapter.dataupdate(dataFromServer.results)

        }
    }


    fun sortedList(list : ArrayList<ResponceArray>): ArrayList<ResponceArray>{

        list.sortWith(Comparator { s1: ResponceArray, s2: ResponceArray ->
            s1.releaseDate?.compareTo(s2.releaseDate!!)!!
        })

        return  list

    }



     val textChageListner  = object : TextWatcher{
         override fun afterTextChanged(s: Editable?) {
         }

         override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
         }

         override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
             adapter.filter(s.toString())
         }

     }


    fun onSearchbuttonClick(view: View) {
      if( visibility.value == false ){
            visibility.value = true
          view.setBackgroundResource(R.drawable.ic_cancle)
      }else{
          view.setBackgroundResource(R.drawable.ic_search)
          visibility.value = false

      }
    }

    fun onCartbuttonClick(view: View) {
        var copydata: ArrayList<ResponceArray> = ArrayList()
        for (setdata in dataFromServer.results) {
            if(setdata.slected != null && setdata.slected == true)
                copydata.add(setdata.copy())
        }

        var intent = Intent(activity, CartListActivity::class.java)
        intent.putExtra("cartData",copydata)
        activity.startActivity(intent)


    }


}