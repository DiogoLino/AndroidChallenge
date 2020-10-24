package com.android.domain.contacts

import com.android.domain.ObservableUseCase
import com.android.domain.PostExecutionThread
import com.android.repository.Heroes
import com.android.repository.contacts.HeroContactsRepository
import com.android.domain.BaseInteractionArgument
import io.reactivex.Observable
import javax.inject.Inject

class HeroContactsUseCase @Inject constructor(
    postExecutionThread: PostExecutionThread,
    private val userRepository: HeroContactsRepository
) : ObservableUseCase<Heroes, BaseInteractionArgument>(postExecutionThread) {

    override fun buildUseCaseObservable(argument: BaseInteractionArgument): Observable<Heroes> {
        return userRepository.loadHeroes()
    }
}