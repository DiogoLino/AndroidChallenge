package com.android.domain

import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

open class BaseSingleObserver<T> : Disposable, SingleObserver<T> {

    private val disposables = CompositeDisposable()

    override fun onError(e: Throwable) {
        Timber.e(e, e.message)
    }

    override fun onSuccess(t: T) = Unit

    override fun onSubscribe(d: Disposable) {
        disposables.add(d)
    }

    override fun dispose() {
        disposables.dispose()
        disposables.clear()
    }

    override fun isDisposed(): Boolean {
        return disposables.isDisposed
    }
}
