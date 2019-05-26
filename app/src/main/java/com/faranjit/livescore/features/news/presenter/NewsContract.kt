package com.faranjit.livescore.features.news.presenter

import com.faranjit.livescore.base.BaseContract
import com.faranjit.livescore.model.NewsItem

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsContract: BaseContract() {

    interface View : BaseContract.View {
        fun loadNewsSuccess(news: List<NewsItem>?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadNews()
    }
}