package com.shivaprasad.myapplication.utils

import android.app.Activity
import android.opengl.Visibility
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.shivaprasad.myapplication.R


@BindingAdapter(value = ["load_image", "context"],requireAll = true)
fun loadImage(view: ImageView, url:String,activity: Activity){

    val options: RequestOptions = RequestOptions()
        // .centerCrop()
        .fitCenter()
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    Glide.with(activity)
        .load(url)
        .apply(options)
        .into(view)
}

@BindingAdapter("onquery")
fun loadQuerytext(view : SearchView, querytext: SearchView.OnQueryTextListener){

    view.setOnQueryTextListener(querytext)

}

@BindingAdapter("onCheckedChangeListner")
fun checkchnaged(view : CheckBox, onCheckedChangeListener: CompoundButton.OnCheckedChangeListener){

    view.setOnCheckedChangeListener(onCheckedChangeListener)

}

@BindingAdapter("setSelected")
fun setSelected(view: TextView, setSelected:Boolean){

    view.isSelected = setSelected
}

@BindingAdapter("imagesrc")
fun setImgSrc(view: ImageView, src : Int){

    view.setImageResource(src)

}

@BindingAdapter("textwatcher")
fun setTextWatcher(view : EditText, textWatcher: TextWatcher){

    view.addTextChangedListener(textWatcher)

}


@BindingAdapter("visibility")
fun visibility(view: EditText, visibility: Boolean) = if(visibility){
    view.visibility = View.VISIBLE
    view.setText("")

}else{
    view.visibility = View.GONE
    view.setText("")

}
