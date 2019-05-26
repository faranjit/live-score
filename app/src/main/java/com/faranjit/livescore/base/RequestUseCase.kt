package com.faranjit.livescore.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
abstract class RequestUseCase<Response, Params> {
    private val compositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params): Single<Response>

    fun execute(observer: DisposableObserver<Response>, params: Params) = bind(observer, params)

    private fun bind(observer: DisposableObserver<Response>, params: Params) {
        val baseContract = observer.baseContract
        val progressLiveData = baseContract.getProgressLiveData()

        add(buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { disposable -> progressLiveData.postValue(ResponseSubscriptionStatus.SUBSCRIBED) }
            .doAfterTerminate { progressLiveData.postValue(ResponseSubscriptionStatus.FINISHED) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer))
    }

    fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}