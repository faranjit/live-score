package com.faranjit.livescore.features.news.presenter

import com.faranjit.livescore.base.DisposableObserver
import com.faranjit.livescore.features.news.domain.GetNews
import com.faranjit.livescore.model.News
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsPresenter @Inject constructor(val contract: NewsContract, val getNews: GetNews) : NewsContract.Presenter {
    private lateinit var view: NewsContract.View

    override fun loadNews() {
        getNews.execute(NewsObserver(contract, view), Unit)
    }

    override fun attach(view: NewsContract.View) {
        this.view = view
    }

    class NewsObserver constructor(val contract: NewsContract, val view: NewsContract.View) :
        DisposableObserver<News>(contract) {

        override fun onResponseSuccess(response: News) {
            view.loadNewsSuccess(response.newsItemList)
        }

        override fun onResponseError(response: News?) {

        }

    }
}