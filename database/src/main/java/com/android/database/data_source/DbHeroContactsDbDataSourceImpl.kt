package com.android.database.data_source

import com.android.database.dao.HeroesDao
import com.android.database.mapper.toEntity
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import com.android.repository.contacts.models.Hero
import javax.inject.Inject


class DbHeroContactsDbDataSourceImpl @Inject constructor(
    private val heroesDao: HeroesDao
) : HeroContactsDbDataSource {

    override fun saveHeroes(heroes: List<Hero>) {
        heroesDao.insertHeroes(heroes.map { it.toEntity() })
    }

//    override fun loadHeroes(offset: Int): Single<List<Heroes>> {
//        return
//    }

    override fun deleteHero() {

    }

    override fun addHeroToSquad() {

    }

//    override fun loadSquad(): Single<List<Heroes>> {
//
//    }


}
