package com.android.presentation.contacts

import com.android.domain.BaseObservableObserver
import com.android.repository.contacts.models.Hero

class SquadObserver(
    private val heroesView: MarvelContactsView
) : BaseObservableObserver<List<Hero>>() {

    override fun onError(e: Throwable) {
        super.onError(e)
        heroesView.hideLoading()
    }

    override fun onNext(t: List<Hero>) {
        heroesView.hideLoading()
        heroesView.onSquadLoaded(t.map { it.toUi() })
    }
}
