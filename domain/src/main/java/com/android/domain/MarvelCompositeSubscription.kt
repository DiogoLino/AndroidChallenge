package com.android.domain

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MarvelCompositeSubscription @Inject constructor() {

    private val compositeSubscription: CompositeDisposable = CompositeDisposable()

    fun add(useCaseSubscription: UseCaseSubscription?) {
        useCaseSubscription?.let { compositeSubscription.add(it.subscription) }
    }

    fun unsubscribe() {
        compositeSubscription.clear()
    }
}
