package com.faranjit.livescore.features.scores.presenter

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.faranjit.livescore.R
import com.faranjit.livescore.base.BaseFragment
import com.faranjit.livescore.model.Match
import com.faranjit.livescore.model.Score
import kotlinx.android.synthetic.main.fragment_scores.*
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
class ScoresFragment : BaseFragment(), ScoresContract.View {
    private var adapter: ScoresAdapter? = null

    @Inject
    lateinit var presenter: ScoresContract.Presenter

    companion object {
        fun newInstance(): ScoresFragment {
            return ScoresFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        initView()
    }

    override fun provideLayoutResId() = R.layout.fragment_scores

    override fun loadScoresSuccess(score: Score?) {
        txtDate.text = score?.parameters?.filter {
            it.name.equals("date")
        }?.get(0)?.value

        val matches = mutableListOf<Match>()
        score?.groups?.forEach {
            matches.addAll(it.matches)
        }

        if (adapter == null) {
            adapter = ScoresAdapter(requireContext(), matches)

            recyclerScores.layoutManager = LinearLayoutManager(requireContext())
            recyclerScores.adapter = adapter
        } else {
            adapter?.let {
                it.matchList = matches
                it.notifyDataSetChanged()
            }
        }

        presenter.startTimer()
    }

    override fun onPause() {
        super.onPause()
        presenter.stopTimer()
    }

    private fun initView() {
        presenter.loadScores()
    }

}