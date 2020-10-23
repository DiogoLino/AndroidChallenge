package com.android.domain

object ApplicationSubscriptionHolder {

    private val subscriptions = MarvelCompositeSubscription()

    fun add(useCaseSubscription: UseCaseSubscription?) {
        useCaseSubscription?.let(subscriptions::add)
    }

    fun unsubscribe() {
        subscriptions.unsubscribe()
    }
}
