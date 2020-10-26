package com.android.domain

import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<in Argument : BaseInteractionArgument>(
    private val postExecutionThread: PostExecutionThread
) {

    abstract fun buildUseCaseObservable(baseInteractionArgument: Argument): Completable

    fun execute(subscriber: BaseCompletableObserver, baseInteractionArgument: Argument): UseCaseSubscription {
        val subscription = buildUseCaseObservable(baseInteractionArgument)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
            .subscribeWith(subscriber)
        return UseCaseSubscription(subscription)
    }
}
