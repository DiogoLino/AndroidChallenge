package com.android.database.dao

import androidx.room.*
import com.android.database.model.HEROES_DB
import com.android.database.model.entities.HeroesEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
abstract class HeroesDao {

    @Query("DELETE FROM $HEROES_DB where id = :id")
    abstract fun deleteHeroById(id: String)

    @Update
    abstract fun update(entity: HeroesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addHeroToSquad(entity: HeroesEntity)

    @Query("SELECT * FROM $HEROES_DB where `offset` = :offset")
    abstract fun loadHeroes(offset: Int): Single<List<HeroesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertHeroes(heroes: List<HeroesEntity>)

}
