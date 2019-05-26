package com.faranjit.livescore.base

import androidx.lifecycle.MutableLiveData

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
open class BaseContract {
    private val progressLiveData = MutableLiveData<ResponseSubscriptionStatus>()

    fun getProgressLiveData(): MutableLiveData<ResponseSubscriptionStatus> {
        return progressLiveData
    }

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {

    }
}