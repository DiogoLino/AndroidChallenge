package com.android.domain

import io.reactivex.disposables.Disposable

class UseCaseSubscription(val subscription: Disposable) {

    fun unsubscribe() {
        subscription.dispose()
    }
}
