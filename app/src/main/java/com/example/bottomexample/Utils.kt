package com.example.bottomexample

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadImage(src: String, @DrawableRes placeHolder: Int? = null) {
    Glide.with(context).load(src).placeholder(placeHolder ?: 0)
         .diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(this)
}

fun Context.toast(message : String){
    Toast.makeText(this, "Clicked on actor: $message", Toast.LENGTH_SHORT).show()
}
