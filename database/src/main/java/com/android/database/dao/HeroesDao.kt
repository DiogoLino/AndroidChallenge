package com.android.database.dao

import androidx.room.*
import com.android.database.model.HEROES_DB
import com.android.database.model.entities.HeroesEntity
import io.reactivex.Single

@Dao
abstract class HeroesDao {

    @Update
    abstract fun updateHero(entity: HeroesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addHeroToSquad(entity: HeroesEntity)

    @Query("SELECT * FROM $HEROES_DB where `offset` = :offset ORDER BY name")
    abstract fun loadHeroes(offset: Int): Single<List<HeroesEntity>>

    @Query("SELECT * FROM $HEROES_DB where squadMember = 1")
    abstract fun loadSquad(): Single<List<HeroesEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertHeroes(heroes: List<HeroesEntity>)

}
