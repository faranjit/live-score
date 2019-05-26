package com.faranjit.livescore.base

import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
abstract class DisposableObserver<Response> constructor(val baseContract: BaseContract): DisposableSingleObserver<Response>() {
    private val TAG = DisposableObserver::class.java.canonicalName

    override fun onSuccess(response: Response) {
        Timber.d(TAG, response)

        onResponseSuccess(response)
    }

    override fun onError(e: Throwable) {
        Timber.e(e)

        onResponseError(null)
    }

    abstract fun onResponseSuccess(response: Response)

    abstract fun onResponseError(response: Response?)
}