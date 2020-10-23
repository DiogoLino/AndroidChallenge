package com.android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.database.dao.UserDao
import com.android.database.model.entities.UserEntity

const val DATABASE_VERSION = 1

@Database(
    version = DATABASE_VERSION,
    entities = [
        UserEntity::class
    ]
)

abstract class MarvelDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
