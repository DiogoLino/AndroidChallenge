package com.android.base_di

import android.app.Activity

interface ActivityComponent<T : Activity> {
    fun inject(activity: T)
}
