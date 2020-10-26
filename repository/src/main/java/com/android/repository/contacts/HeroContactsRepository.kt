package com.android.repository.contacts

import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import com.android.repository.contacts.models.Hero
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject


class HeroContactsRepository @Inject constructor(
    private val heroContactsApiDataSource: HeroContactsApiDataSource,
    private val heroContactsDbDataSource: HeroContactsDbDataSource
) {

    fun loadHeroes(offset: Int): Observable<List<Hero>> {
        return heroContactsApiDataSource.loadHeroes(offset)
    }


    private fun loadFromApi(offset: Int): Observable<List<Hero>> {
        return heroContactsApiDataSource.loadHeroes(offset)
            .doOnError { error -> Timber.e(error, "Db is empty and api failed") }
            .doAfterNext { heroContactsDbDataSource.saveHeroes(it) }
    }

//    private fun loadFromDb(offset: Int): Observable<List<Heroes>> {
//        return heroContactsDbDataSource.loadHeroes(offset)
//            .doOnError { error -> Timber.e(error, "Db is empty") }
//    }

//
//fun loadFromDb() {
//
//}
//
//fun loadUserGrammar(
//    componentId: String,
//    courseLanguage: Language,
//    translationLanguages: List<Language>,
//    loadFromApi: Boolean
//): Observable<GrammarReview> {
//
//
//}
//
//private fun loadFromDb(
//    componentId: String,
//    language: Language,
//    translationLanguages: List<Language>
//): Observable<GrammarReview> {
//    return grammarReviewDbDataSource.loadGrammar(componentId, language, translationLanguages)
//        .doOnError { error -> Timber.e(error, "Db is empty") }
//}

}
