package com.android.api.contacts.model

import com.google.gson.annotations.SerializedName

data class ApiBaseMarvel(
    @SerializedName("data") val data: ApiHeroesData
)
