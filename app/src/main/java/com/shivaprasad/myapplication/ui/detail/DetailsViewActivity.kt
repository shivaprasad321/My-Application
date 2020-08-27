package com.shivaprasad.myapplication.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.shivaprasad.myapplication.R
import com.shivaprasad.myapplication.data.model.ResponceData.*
import com.shivaprasad.myapplication.databinding.ActivityDetailsViewBinding
import com.shivaprasad.task.utils.Utils

class DetailsViewActivity : AppCompatActivity() {
    lateinit var activityDetailScreenBinding: ActivityDetailsViewBinding
    lateinit var data: ResponceArray
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailScreenBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_details_view
        )
        if(intent.extras != null){
            data = intent.getSerializableExtra("data") as ResponceArray

            activityDetailScreenBinding.data = data
        }
        activityDetailScreenBinding.activity = this
        activityDetailScreenBinding.lifecycleOwner = this
        activityDetailScreenBinding.artistTrack.isSelected = true

    }

    fun dateUpdate(date:String):String{
        return Utils.chageDateFormat(date)
    }

    fun  onClick(){
        this.finish()
    }
}
