package com.faranjit.livescore.features.news.data

import com.faranjit.livescore.api.RssApi
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsDataSource @Inject constructor(val rssApi: RssApi) {

    fun getNews() = rssApi.getNews()
}