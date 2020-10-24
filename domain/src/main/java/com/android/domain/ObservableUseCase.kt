package com.android.domain

import io.reactivex.Observable
import io.reactivex.annotations.NonNull
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<ResultType, in Argument : BaseInteractionArgument> protected constructor(
    private val postExecutionThread: PostExecutionThread
) {
    abstract fun buildUseCaseObservable(@NonNull argument: Argument): Observable<ResultType>

    fun execute(
        subscriber: BaseObservableObserver<ResultType>,
        baseInteractionArgument: Argument
    ): UseCaseSubscription {
        val subscription = buildUseCaseObservable(baseInteractionArgument)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
            .subscribeWith(subscriber)
        return UseCaseSubscription(subscription)
    }
}
