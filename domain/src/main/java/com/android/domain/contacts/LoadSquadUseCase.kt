package com.android.domain.contacts

import com.android.domain.BaseInteractionArgument
import com.android.domain.ObservableUseCase
import com.android.domain.PostExecutionThread
import com.android.repository.contacts.HeroContactsRepository
import com.android.repository.contacts.models.Hero
import io.reactivex.Observable
import javax.inject.Inject

class LoadSquadUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val userRepository: HeroContactsRepository
) : ObservableUseCase<List<Hero>, BaseInteractionArgument>(postExecutionThread) {

    override fun buildUseCaseObservable(argument: BaseInteractionArgument): Observable<List<Hero>> {
        return userRepository.loadSquad()
    }
}