package com.android.repository.contacts.data_source

import com.android.repository.contacts.models.Hero
import io.reactivex.Observable

interface HeroContactsApiDataSource {

    fun loadHeroes(offset: Int): Observable<List<Hero>>
}