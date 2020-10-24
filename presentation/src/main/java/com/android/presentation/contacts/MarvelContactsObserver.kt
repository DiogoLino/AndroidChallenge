package com.android.presentation.contacts

import com.android.domain.BaseObservableObserver
import com.android.repository.contacts.models.Heroes

class MarvelContactsObserver(
    private val heroesView: MarvelContactsView
) : BaseObservableObserver<List<Heroes>>() {

    override fun onError(e: Throwable) {
        super.onError(e)
        heroesView.hideLoading()
        // grammarView.showErrorLoadingReviewGrammar()
    }

    override fun onNext(t: List<Heroes>) {
        heroesView.hideLoading()
        heroesView.onHeroesLoaded(t)
        // map to UI
    }
}