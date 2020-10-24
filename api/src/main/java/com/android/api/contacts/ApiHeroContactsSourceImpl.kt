package com.android.api.contacts

import com.android.api.MarvelApiService
import com.android.api.contacts.mappers.toDomain
import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.models.Heroes
import io.reactivex.Observable
import javax.inject.Inject

class ApiHeroContactsSourceImpl @Inject constructor(
    private val apiService: MarvelApiService
) : HeroContactsApiDataSource {

    override fun loadHeroes(): Observable<List<Heroes>> {
        return apiService.loadHeroes()
            .map { apiBaseMarvel ->
                apiBaseMarvel.data.apiHeroes.map { it.toDomain() }
            }
    }

}
