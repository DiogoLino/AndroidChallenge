package com.android.repository.contacts.models


data class Hero(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailPath: String,
    val offset: Int,
    val squadMember: Boolean = false,
    val shouldShowSquad: Boolean = false

)