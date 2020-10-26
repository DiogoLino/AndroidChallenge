package com.android.presentation.contacts

import com.android.domain.MarvelCompositeSubscription
import com.android.domain.contacts.LoadHeroesUseCase
import com.android.presentation.BasePresenter
import javax.inject.Inject

class MarvelContactsPresenter @Inject constructor(
    marvelCompositeSubscription: MarvelCompositeSubscription,
    private val view: MarvelContactsView,
    private val loadHeroesUseCase: LoadHeroesUseCase
) : BasePresenter(marvelCompositeSubscription) {

    fun loadHeroContacts() {
        addSubscription(
            loadHeroesUseCase.execute(
                MarvelContactsObserver(view),
                LoadHeroesUseCase.InteractionArgument(2)
            )
        )
    }
}
