package com.android.presentation.contacts

import com.android.domain.BaseInteractionArgument
import com.android.domain.MarvelCompositeSubscription
import com.android.domain.contacts.LoadHeroesUseCase
import com.android.domain.contacts.LoadSquadUseCase
import com.android.presentation.BasePresenter
import javax.inject.Inject

class MarvelContactsPresenter @Inject constructor(
    marvelCompositeSubscription: MarvelCompositeSubscription,
    private val view: MarvelContactsView,
    private val loadHeroesUseCase: LoadHeroesUseCase,
    private val loadSquadUseCase: LoadSquadUseCase
) : BasePresenter(marvelCompositeSubscription) {

    fun loadHeroContacts(offset : Int) {
        addSubscription(
            loadHeroesUseCase.execute(
                MarvelContactsObserver(view),
                LoadHeroesUseCase.InteractionArgument(offset)
            )
        )
    }

    fun loadSquad() {
        addSubscription(
            loadSquadUseCase.execute(
                SquadObserver(view),
                BaseInteractionArgument()
            )
        )
    }
}
