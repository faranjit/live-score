package com.faranjit.livescore.features.scores.presenter

import com.faranjit.livescore.base.BaseContract
import com.faranjit.livescore.model.Score

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
class ScoresContract : BaseContract() {
    interface View : BaseContract.View {
        fun loadScoresSuccess(score: Score?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadScores()

        fun startTimer()

        fun stopTimer()
    }
}