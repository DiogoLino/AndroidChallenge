package com.android.repository.contacts.data_source

import com.android.repository.contacts.models.Hero
import io.reactivex.Single

interface HeroContactsDbDataSource {

    fun saveHeroes(heroes: List<Hero>)
    fun loadHeroes(offset: Int): Single<List<Hero>>
    fun loadSquad(): Single<List<Hero>>
    fun removeHeroFromSquad(uiHero: Hero)
    fun addHeroToSquad(uiHero: Hero)
}