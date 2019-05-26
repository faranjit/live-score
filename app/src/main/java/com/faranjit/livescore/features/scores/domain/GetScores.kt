package com.faranjit.livescore.features.scores.domain

import com.faranjit.livescore.base.RequestUseCase
import com.faranjit.livescore.model.Score
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
class GetScores @Inject constructor(val scoresRepository: ScoresRepository) : RequestUseCase<Score, Unit>() {

    override fun buildUseCaseObservable(params: Unit): Single<Score> = scoresRepository.getScores()
}