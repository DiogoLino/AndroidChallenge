package com.android.presentation

import com.android.domain.ApplicationSubscriptionHolder
import com.android.domain.MarvelCompositeSubscription
import com.android.domain.UseCaseSubscription

open class BasePresenter(private val compositeSubscription: MarvelCompositeSubscription) {

    fun addSubscription(useCaseSubscription: UseCaseSubscription?) {
        compositeSubscription.add(useCaseSubscription)
    }

    fun addGlobalSubscription(useCaseSubscription: UseCaseSubscription?) {
        ApplicationSubscriptionHolder.add(useCaseSubscription)
    }

    open fun onDestroy() {
        compositeSubscription.unsubscribe()
    }
}
