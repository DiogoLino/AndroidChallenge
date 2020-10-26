package com.android.database.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.database.model.HEROES_DB

@Entity(tableName = HEROES_DB)
data class HeroesEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailPath: String,
    val offset: Int,
    val squadMember: Boolean = false
)

