package com.android.presentation.contacts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiHeroThumbnail(
    val path: String,
    val extension: String
) : Parcelable
