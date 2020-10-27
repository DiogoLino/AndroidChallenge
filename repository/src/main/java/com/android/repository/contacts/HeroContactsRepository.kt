package com.android.repository.contacts

import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import com.android.repository.contacts.models.Hero
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class HeroContactsRepository @Inject constructor(
    private val heroContactsApiDataSource: HeroContactsApiDataSource,
    private val heroContactsDbDataSource: HeroContactsDbDataSource
) {

    fun loadHeroes(offset: Int): Observable<List<Hero>> {
        return loadFromDb(offset)
            .filter { list -> list.isNotEmpty() }
            .switchIfEmpty(
                loadFromApi(offset)
                    .doOnNext { heroContactsDbDataSource.saveHeroes(it) }
            )
    }

    private fun loadFromApi(offset: Int): Observable<List<Hero>> {
        return heroContactsApiDataSource.loadHeroes(offset)
    }

    private fun loadFromDb(offset: Int): Observable<List<Hero>> {
        return heroContactsDbDataSource.loadHeroes(offset)
            .toObservable()
    }

    fun loadSquad(): Observable<List<Hero>> {
        return heroContactsDbDataSource.loadSquad()
            .toObservable()
    }


    fun removeHeroFromSquad(hero: Hero): Completable {
        return Completable.fromAction { heroContactsDbDataSource.removeHeroFromSquad(hero) }
    }

    fun addHeroToSquad(hero: Hero): Completable {
        return Completable.fromAction { heroContactsDbDataSource.addHeroToSquad(hero) }
    }
}
