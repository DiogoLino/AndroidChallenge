package com.android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.database.dao.HeroesDao
import com.android.database.model.entities.HeroesEntity

const val DATABASE_VERSION = 1

@Database(
    version = DATABASE_VERSION,
    entities = [
        HeroesEntity::class
    ]
)

abstract class MarvelDatabase : RoomDatabase() {
    abstract fun heroesDao(): HeroesDao
}
