package com.android.domain.contacts

import com.android.domain.BaseInteractionArgument
import com.android.domain.ObservableUseCase
import com.android.domain.PostExecutionThread
import com.android.repository.contacts.HeroContactsRepository
import com.android.repository.contacts.models.Hero
import io.reactivex.Observable
import javax.inject.Inject

class HeroContactsUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val userRepository: HeroContactsRepository
) : ObservableUseCase<List<Hero>, HeroContactsUseCase.InteractionArgument>(postExecutionThread) {

    override fun buildUseCaseObservable(argument: InteractionArgument): Observable<List<Hero>> {
        return userRepository.loadHeroes(argument.offset)
    }


    data class InteractionArgument(
        val offset: Int
    ) : BaseInteractionArgument()
}