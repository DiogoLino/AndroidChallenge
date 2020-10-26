package com.android.domain.contacts

import com.android.domain.BaseInteractionArgument
import com.android.domain.ObservableUseCase
import com.android.domain.PostExecutionThread
import com.android.domain.SingleUseCase
import com.android.repository.contacts.HeroContactsRepository
import com.android.repository.contacts.models.Hero
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class LoadHeroesUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val userRepository: HeroContactsRepository
) : ObservableUseCase<List<Hero>, LoadHeroesUseCase.InteractionArgument>(postExecutionThread) {

    override fun buildUseCaseObservable(argument: InteractionArgument): Observable<List<Hero>> {
        return userRepository.loadHeroes(argument.offset)
    }

    data class InteractionArgument(
        val offset: Int
    ) : BaseInteractionArgument()
}