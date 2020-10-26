package com.android.database

import android.content.Context
import android.os.Debug
import androidx.room.Room
import com.android.database.dao.HeroesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

const val ROOM_DATABASE = "database"

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): MarvelDatabase {
        val builder = Room.databaseBuilder(
            context.applicationContext,
            MarvelDatabase::class.java,
            ROOM_DATABASE
        )
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: MarvelDatabase): HeroesDao {
        return db.heroesDao()
    }

}
