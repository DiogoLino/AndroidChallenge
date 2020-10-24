package com.android.api.contacts.model

import com.google.gson.annotations.SerializedName

data class ApiHeroesData(
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val total: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val apiHeroes: List<ApiHeroes>
)