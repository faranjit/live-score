package com.faranjit.livescore.features.news.data

import com.faranjit.livescore.features.news.domain.NewsRepository
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsDataRepository @Inject constructor(val newsDataSource: NewsDataSource) : NewsRepository {

    override fun getNews() = newsDataSource.getNews()

}