package com.android.presentation.contacts


data class UiHero(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailPath: String,
    val offset: Int,
    val squadMember: Boolean = false,
    val shouldShowSquad: Boolean = false
)