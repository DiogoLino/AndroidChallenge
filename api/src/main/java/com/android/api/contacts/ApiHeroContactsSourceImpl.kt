package com.android.api.contacts

import com.android.api.MarvelApiService
import com.android.api.contacts.mappers.toDomain
import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.models.Hero
import io.reactivex.Observable
import javax.inject.Inject

class ApiHeroContactsSourceImpl @Inject constructor(
    private val apiService: MarvelApiService
) : HeroContactsApiDataSource {

    override fun loadHeroes(offset: Int): Observable<List<Hero>> {
        return apiService.loadHeroes(offset)
            .map { apiBaseMarvel ->
                apiBaseMarvel.data.apiHeroes.map { it.toDomain(apiBaseMarvel.data.offset) }
            }
    }
}
