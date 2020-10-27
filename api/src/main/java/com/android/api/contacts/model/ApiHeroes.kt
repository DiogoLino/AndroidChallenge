package com.android.api.contacts.model

import com.google.gson.annotations.SerializedName

data class ApiHeroes(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val apiHeroThumbnail: ApiHeroThumbnail
)