package com.android.repository.contacts

import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import com.android.repository.contacts.models.Heroes
import io.reactivex.Observable
import javax.inject.Inject


class HeroContactsRepository @Inject constructor(
    private val heroContactsApiDataSource: HeroContactsApiDataSource,
    private val heroContactsDbDataSource: HeroContactsDbDataSource
) {

    fun loadHeroes(): Observable<List<Heroes>> {
        return heroContactsApiDataSource.loadHeroes()
    }

}
