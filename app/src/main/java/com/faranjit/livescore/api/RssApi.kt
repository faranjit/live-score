package com.faranjit.livescore.api

import com.faranjit.livescore.model.News
import com.faranjit.livescore.model.Score
import io.reactivex.Single
import retrofit2.http.GET


/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
interface RssApi {

    @GET("latestnews.xml")
    fun getNews(): Single<News>

    @GET("scores.xml")
    fun getScores(): Single<Score>
}