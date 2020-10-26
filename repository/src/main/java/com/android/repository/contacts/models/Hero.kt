package com.android.repository.contacts.models


data class Hero(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailPath: HeroThumbnail,
    val offset: Int,
    val squadMember: Boolean = false,
    val shouldShowSquad: Boolean = false
)