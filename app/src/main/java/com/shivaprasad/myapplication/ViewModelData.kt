package com.shivaprasad.myapplication

import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.ViewModel
import com.shivaprasad.myapplication.ResponceData.Responce
import java.util.*
import kotlin.collections.ArrayList

class ViewModelData(val api: API, val repository: Repository, val activity: MainActivity): ViewModel() {


    var employessDataFromServer : Responce = ResponceData.Responce(0, ArrayList<ResponceData.ResponceArray>())

    var adapter = RecycleAdapter(
        R.layout.listitem,
        employessDataFromServer,
        this,
        activity

    )

    fun setAdapter(): RecycleAdapter {
        return adapter
    }

    fun setCheck(position: Int):Boolean{

        return  if(employessDataFromServer.results[position].slected){

            employessDataFromServer.results[position].slected = false
            false
        }else{
            employessDataFromServer.results[position].slected = true
            true
        }

    }


  fun setListpositionvalue(position: Int): ResponceData.ResponceArray{
   return   employessDataFromServer.results[position]
  }

    fun updateData(){
        Coroutines.main(){

            var data = this.repository.newsdata()
            Log.d("data", data.code().toString())

            Log.d("data", data.body().toString())

            employessDataFromServer   = data.body()!!

            employessDataFromServer.results = sortedList(employessDataFromServer.results)


            Log.d("data", data.message())

            Log.d("data", data.raw().toString())

            adapter.dataupdate(employessDataFromServer)

        }
    }


    fun sortedList(list : ArrayList<ResponceData.ResponceArray>): ArrayList<ResponceData.ResponceArray>{

        list.sortWith(Comparator { s1: ResponceData.ResponceArray, s2: ResponceData.ResponceArray ->
            s1.releaseDate.compareTo(s2.releaseDate)
        })

        return  list

    }

     val queryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String): Boolean {
            adapter.filter(newText)
            return true
        }

        override fun onQueryTextSubmit(newQuery: String): Boolean {
            return true
        }
    }


}