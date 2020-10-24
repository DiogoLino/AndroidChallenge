package com.android.repository.contacts

import com.android.repository.Heroes
import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import io.reactivex.Observable
import javax.inject.Inject


class HeroContactsRepository @Inject constructor(
    private val heroContactsApiDataSource: HeroContactsApiDataSource,
    private val heroContactsDbDataSource: HeroContactsDbDataSource
) {


     fun loadHeroes(): Observable<Heroes> {
        return  heroContactsApiDataSource.loadHeroes()
    }

}
