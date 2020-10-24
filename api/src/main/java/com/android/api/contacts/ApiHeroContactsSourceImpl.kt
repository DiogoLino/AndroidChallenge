package com.android.api.contacts

import com.android.api.MarvelApiService
import com.android.repository.Heroes
import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import io.reactivex.Observable
import javax.inject.Inject

class ApiHeroContactsSourceImpl @Inject constructor(
    private val apiService: MarvelApiService
) : HeroContactsApiDataSource {

    override fun loadHeroes(): Observable<Heroes> {
        return apiService.loadHeroes()
    }

}
