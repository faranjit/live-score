package com.faranjit.livescore.features.scores.data

import com.faranjit.livescore.api.RssApi
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
class ScoresDataSource @Inject constructor(val rssApi: RssApi) {

    fun getScores() = rssApi.getScores()
}