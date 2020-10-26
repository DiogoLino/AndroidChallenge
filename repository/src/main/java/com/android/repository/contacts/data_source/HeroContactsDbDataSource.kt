package com.android.repository.contacts.data_source

import com.android.repository.contacts.models.Hero
import io.reactivex.Single

interface HeroContactsDbDataSource {

    fun saveHeroes(heroes: List<Hero>)
    fun loadHeroes(offset: Int): Single<List<Hero>>
    fun deleteHero()
    fun addHeroToSquad()
}