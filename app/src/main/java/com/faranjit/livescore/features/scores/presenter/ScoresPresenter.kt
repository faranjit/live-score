package com.faranjit.livescore.features.scores.presenter

import android.os.CountDownTimer
import com.faranjit.livescore.base.DisposableObserver
import com.faranjit.livescore.features.scores.domain.GetScores
import com.faranjit.livescore.model.Score
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
class ScoresPresenter @Inject constructor(val contract: ScoresContract, val getScores: GetScores) :
    ScoresContract.Presenter {

    private lateinit var view: ScoresContract.View

    private var timer: CountDownTimer? = null

    override fun loadScores() {
        getScores.execute(ScoresObserver(contract, view), Unit)
    }

    override fun startTimer() {
        if (timer != null) {
            timer!!.cancel()
        }

        timer = object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                loadScores()
            }
        }

        timer?.start()
    }

    override fun stopTimer() {
        timer?.cancel()
    }

    override fun attach(view: ScoresContract.View) {
        this.view = view
    }

    class ScoresObserver constructor(val contract: ScoresContract, val view: ScoresContract.View) :
        DisposableObserver<Score>(contract) {

        override fun onResponseSuccess(response: Score) {
            view.loadScoresSuccess(response)
        }

        override fun onResponseError(response: Score?) {

        }

    }
}