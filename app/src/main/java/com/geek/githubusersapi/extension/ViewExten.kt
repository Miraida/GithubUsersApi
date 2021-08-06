package com.geek.githubusersapi.extension

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.visibility(isVisible: Boolean) {
    if (isVisible) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}
fun ImageView.loadImage(url:String){
    Glide.with(this)
        .load(url)
        .into(this)
}