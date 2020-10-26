package com.android.domain.details

import com.android.domain.BaseInteractionArgument
import com.android.domain.CompletableUseCase
import com.android.domain.PostExecutionThread
import com.android.repository.contacts.HeroContactsRepository
import com.android.repository.contacts.models.Hero
import io.reactivex.Completable
import javax.inject.Inject

class RemoveHeroUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val heroRepository: HeroContactsRepository
) : CompletableUseCase<RemoveHeroUseCase.InteractionArgument>(postExecutionThread) {

    override fun buildUseCaseObservable(baseInteractionArgument: InteractionArgument): Completable {
        return heroRepository.removeHeroFromSquad(baseInteractionArgument.uiHero)
    }

    data class InteractionArgument(
        val uiHero: Hero
    ) : BaseInteractionArgument()
}