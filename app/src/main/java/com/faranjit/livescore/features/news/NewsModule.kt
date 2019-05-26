package com.faranjit.livescore.features.news

import com.faranjit.livescore.api.RssApi
import com.faranjit.livescore.features.news.data.NewsDataRepository
import com.faranjit.livescore.features.news.data.NewsDataSource
import com.faranjit.livescore.features.news.domain.GetNews
import com.faranjit.livescore.features.news.domain.NewsRepository
import com.faranjit.livescore.features.news.presenter.NewsContract
import com.faranjit.livescore.features.news.presenter.NewsPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
@Module
class NewsModule {

    @Provides
    fun provideNewsContract(): NewsContract = NewsContract()

    @Provides
    fun provideNewsPresenter(contract: NewsContract, getNews: GetNews): NewsContract.Presenter =
        NewsPresenter(contract, getNews)

    @Provides
    fun provideNewsDataSource(retrofit: Retrofit): NewsDataSource =
        NewsDataSource(retrofit.create(RssApi::class.java))

    @Provides
    fun provideNewsRepository(newsDataSource: NewsDataSource): NewsRepository =
        NewsDataRepository(newsDataSource)
}