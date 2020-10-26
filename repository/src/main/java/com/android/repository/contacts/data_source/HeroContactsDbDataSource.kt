package com.android.repository.contacts.data_source

import com.android.repository.contacts.models.Hero
import io.reactivex.Completable
import io.reactivex.Single

interface HeroContactsDbDataSource {

    fun saveHeroes(heroes: List<Hero>)
    fun loadHeroes(offset: Int): Single<List<Hero>>
    fun removeHeroFromSquad(uiHero: Hero) : Completable
    fun addHeroToSquad(uiHero: Hero) : Completable
}