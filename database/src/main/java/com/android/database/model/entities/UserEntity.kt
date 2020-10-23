package com.android.database.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.database.model.USER_DB

@Entity(tableName = USER_DB)
data class UserEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String?
)

data class UserAvatarDb(
    val smallUrl: String?,
    val originalUrl: String?,
    val hasAvatar: Boolean
)
