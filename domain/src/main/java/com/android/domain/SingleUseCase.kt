package com.android.domain

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<ResultType, in Argument : BaseInteractionArgument>(
    private val postExecutionThread: PostExecutionThread
) {
    abstract fun buildUseCaseObservable(baseInteractionArgument: Argument): Single<ResultType>

    fun execute(observer: BaseSingleObserver<ResultType>, baseInteractionArgument: Argument): UseCaseSubscription {
        val subscription = buildUseCaseObservable(baseInteractionArgument)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
            .subscribeWith(observer)
        return UseCaseSubscription(subscription)
    }

    fun unsubscribe(useCaseSubscription: UseCaseSubscription?) {
        useCaseSubscription?.unsubscribe()
    }
}