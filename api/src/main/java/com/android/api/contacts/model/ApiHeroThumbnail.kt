package com.android.api.contacts.model

import com.google.gson.annotations.SerializedName

data class ApiHeroThumbnail(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)
