package com.android.database.data_source

import com.android.database.dao.HeroesDao
import com.android.database.mapper.toDomain
import com.android.database.mapper.toEntity
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import com.android.repository.contacts.models.Hero
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class DbHeroContactsDbDataSourceImpl @Inject constructor(
    private val heroesDao: HeroesDao
) : HeroContactsDbDataSource {

    override fun saveHeroes(heroes: List<Hero>) {
        heroesDao.insertHeroes(heroes.map { it.toEntity() })
    }

    override fun loadHeroes(offset: Int): Single<List<Hero>> {
        return heroesDao.loadHeroes(offset).map { heroes -> heroes.map { it.toDomain() } }
    }


    override fun deleteHero() {

    }

    override fun addHeroToSquad() {

    }


}
