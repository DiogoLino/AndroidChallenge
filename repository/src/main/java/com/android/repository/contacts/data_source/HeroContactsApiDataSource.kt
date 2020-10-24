package com.android.repository.contacts.data_source

import com.android.repository.Heroes
import io.reactivex.Observable

interface HeroContactsApiDataSource {

    fun loadHeroes() : Observable<Heroes>
}