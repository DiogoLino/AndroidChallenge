package com.android.androidchallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseMarvelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView()
    }

    protected abstract fun setContentView()

    protected abstract fun inject()

}
