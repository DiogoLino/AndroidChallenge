package com.android.androidchallenge.utils

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.visible() {
    this.visibility = VISIBLE
}

fun View.gone() {
    this.visibility = GONE
}


val View.inflater: LayoutInflater
    get() = LayoutInflater.from(context)







