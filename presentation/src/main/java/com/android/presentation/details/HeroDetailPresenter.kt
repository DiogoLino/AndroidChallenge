package com.android.presentation.details

import com.android.domain.MarvelCompositeSubscription
import com.android.domain.details.RemoveHeroUseCase
import com.android.presentation.BasePresenter
import com.android.presentation.contacts.UiHero
import com.android.presentation.contacts.toDomain
import javax.inject.Inject

class HeroDetailPresenter @Inject constructor(
    marvelCompositeSubscription: MarvelCompositeSubscription,
    private val view: HeroContactDetailsView,
    private val removeHeroUseCase: RemoveHeroUseCase,
    private val addHeroUseCase: AddHeroUseCase

) : BasePresenter(marvelCompositeSubscription) {

    fun removeHeroFromSquad(uiHero: UiHero) {
        uiHero.toDomain()
        addSubscription(
            removeHeroUseCase.execute(
                HeroDetailsRemoveObserver(view),
                RemoveHeroUseCase.InteractionArgument(uiHero.toDomain())
            )
        )
    }

    fun addHeroToSquad(uiHero: UiHero) {
        addSubscription(
            addHeroUseCase.execute(
                HeroDetailsAddObserver(view),
                AddHeroUseCase.InteractionArgument(uiHero.toDomain())
            )
        )
    }
}