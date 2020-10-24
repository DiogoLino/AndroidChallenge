package com.android.repository.contacts.data_source

import com.android.repository.contacts.models.Heroes
import io.reactivex.Observable

interface HeroContactsApiDataSource {

    fun loadHeroes() : Observable<List<Heroes>>
}