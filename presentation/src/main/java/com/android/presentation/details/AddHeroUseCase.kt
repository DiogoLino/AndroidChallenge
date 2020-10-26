package com.android.presentation.details

import com.android.domain.BaseInteractionArgument
import com.android.domain.CompletableUseCase
import com.android.domain.PostExecutionThread
import com.android.repository.contacts.HeroContactsRepository
import com.android.repository.contacts.models.Hero
import io.reactivex.Completable
import javax.inject.Inject

class AddHeroUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val heroRepository: HeroContactsRepository
) : CompletableUseCase<AddHeroUseCase.InteractionArgument>(postExecutionThread) {

    override fun buildUseCaseObservable(baseInteractionArgument: InteractionArgument): Completable {
        return heroRepository.addHeroToSquad(baseInteractionArgument.hero)
    }

    data class InteractionArgument(
        val hero: Hero
    ) : BaseInteractionArgument()
}