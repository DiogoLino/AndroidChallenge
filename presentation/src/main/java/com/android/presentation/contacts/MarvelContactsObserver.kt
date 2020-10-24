package com.android.presentation.contacts

import com.android.domain.BaseObservableObserver
import com.android.repository.Heroes

class MarvelContactsObserver(
    private val heroesView: MarvelContactsView
) : BaseObservableObserver<Heroes>() {

    override fun onError(e: Throwable) {
        super.onError(e)
        heroesView.hideLoading()
        // grammarView.showErrorLoadingReviewGrammar()
    }

    override fun onNext(t: Heroes) {
        heroesView.hideLoading()
        //    heroesView.onHeroesLoaded(t)
        // map to UI
    }
}