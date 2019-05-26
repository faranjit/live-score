package com.faranjit.livescore.features.scores.domain

import com.faranjit.livescore.model.Score
import io.reactivex.Single

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
interface ScoresRepository {
    fun getScores(): Single<Score>
}