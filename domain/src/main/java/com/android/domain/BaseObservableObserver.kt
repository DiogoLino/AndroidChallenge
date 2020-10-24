package com.android.domain

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

open class BaseObservableObserver<T> : Disposable, Observer<T> {

    private val disposables = CompositeDisposable()

    override fun onError(e: Throwable) {
        Timber.e(e, e.message)
    }

    override fun onComplete() = Unit

    override fun onSubscribe(d: Disposable) {
        disposables.add(d)
    }

    override fun onNext(t: T) = Unit

    override fun dispose() {
        disposables.dispose()
        disposables.clear()
    }

    override fun isDisposed(): Boolean = disposables.isDisposed
}
