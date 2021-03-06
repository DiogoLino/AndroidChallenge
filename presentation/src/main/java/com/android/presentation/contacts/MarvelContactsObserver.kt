package com.android.presentation.contacts

import com.android.domain.BaseObservableObserver
import com.android.repository.contacts.models.Hero
import com.android.repository.contacts.models.HeroThumbnail

class MarvelContactsObserver(
    private val heroesView: MarvelContactsView
) : BaseObservableObserver<List<Hero>>() {

    override fun onError(e: Throwable) {
        super.onError(e)
        heroesView.hideLoading()
    }

    override fun onNext(t: List<Hero>) {
        heroesView.hideLoading()
        heroesView.onHeroesLoaded(t.map { it.toUi() })
    }
}


fun Hero.toUi() = UiHero(
    id = id,
    name = name,
    description = description,
    offset = offset,
    thumbnailPath = thumbnailPath.toUi(),
    squadMember = squadMember
)

fun HeroThumbnail.toUi() = UiHeroThumbnail(
    path = path,
    extension = extension
)