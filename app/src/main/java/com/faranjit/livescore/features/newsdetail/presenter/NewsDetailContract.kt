package com.faranjit.livescore.features.newsdetail.presenter

import com.faranjit.livescore.base.BaseContract

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsDetailContract : BaseContract() {
    interface View : BaseContract.View {
        fun loadDetailSuccess()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadDetail(url: String)
    }

}