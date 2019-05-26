package com.faranjit.livescore.features.news.domain

import com.faranjit.livescore.model.News
import io.reactivex.Single

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
public interface NewsRepository {
    fun getNews(): Single<News>
}