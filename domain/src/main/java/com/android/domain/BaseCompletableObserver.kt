package com.android.domain

import io.reactivex.observers.DisposableCompletableObserver
import timber.log.Timber

open class BaseCompletableObserver : DisposableCompletableObserver() {

    override fun onError(e: Throwable) {
        Timber.e(e, "Error during completable")
    }

    override fun onComplete() {
    }
}
