package com.android.database.model.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.database.model.HEROES_DB

@Entity(tableName = HEROES_DB)
data class HeroesEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    @Embedded
    val thumbnail: HeroAvatarDb,
    val offset: Int,
    val squadMember: Boolean = false
)

data class HeroAvatarDb(
    val path: String,
    val extension: String
)

