package com.android.presentation.contacts

import com.android.domain.MarvelCompositeSubscription
import com.android.domain.contacts.HeroContactsUseCase
import com.android.presentation.BasePresenter
import com.android.domain.BaseInteractionArgument
import javax.inject.Inject

class MarvelContactsPresenter @Inject constructor(
    marvelCompositeSubscription: MarvelCompositeSubscription,
    private val view: MarvelContactsView,
    private val heroContactsUseCase: HeroContactsUseCase
) : BasePresenter(marvelCompositeSubscription) {

    fun loadHeroContacts() {
        addSubscription(
            heroContactsUseCase.execute(
                MarvelContactsObserver(view),
                BaseInteractionArgument()
            )
        )
    }
}
