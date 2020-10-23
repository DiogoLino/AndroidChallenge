package com.android.androidchallenge

import okhttp3.OkHttpClient

interface OkHttpProvider {
    val okHttpClient: OkHttpClient
}
