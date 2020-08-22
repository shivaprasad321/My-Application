package com.shivaprasad.myapplication

import android.app.Activity
import android.widget.ImageView
import android.widget.SearchView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


@BindingAdapter(value = ["load_image", "context"],requireAll = true)
fun loadImage(view: ImageView, url:String,activity: Activity){

    val options: RequestOptions = RequestOptions()
        .centerCrop()
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
