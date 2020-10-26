package com.android.imageloader

import okhttp3.OkHttpClient

interface OkHttpProvider {
    val okHttpClient: OkHttpClient
}
