package com.android.repository.contacts.data_source

import com.android.repository.contacts.models.Hero

interface HeroContactsDbDataSource {

    fun saveHeroes(heroes: List<Hero>)
 //   fun loadHeroes(offset: Int): Observable<List<Heroes>>
    fun deleteHero()
    fun addHeroToSquad()
  //  fun loadSquad(): Observable<List<Heroes>>

}