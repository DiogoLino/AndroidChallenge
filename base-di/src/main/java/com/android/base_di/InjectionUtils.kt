package com.android.base_di

import android.content.Context

val Context.appComponent: AppComponent
    get() = (this.applicationContext as ComponentProvider)[AppComponent::class.java]
