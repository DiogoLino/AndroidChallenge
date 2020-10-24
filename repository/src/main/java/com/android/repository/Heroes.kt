package com.android.repository

import com.google.gson.annotations.SerializedName


data class Heroes(
    @SerializedName("status") val status: String
)