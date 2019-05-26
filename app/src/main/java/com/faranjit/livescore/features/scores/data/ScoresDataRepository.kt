package com.faranjit.livescore.features.scores.data

import com.faranjit.livescore.features.scores.domain.ScoresRepository
import com.faranjit.livescore.model.Score
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
class ScoresDataRepository @Inject constructor(val scoresDataSource: ScoresDataSource) : ScoresRepository {

    override fun getScores(): Single<Score> = scoresDataSource.getScores()
}