package com.faranjit.livescore.features.scores.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faranjit.livescore.R
import com.faranjit.livescore.model.Match
import kotlinx.android.synthetic.main.layout_score_item.view.*

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
class ScoresAdapter(
    val context: Context,
    var matchList: List<Match>
) :
    RecyclerView.Adapter<ScoresAdapter.ScoresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoresViewHolder {
        return ScoresViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_score_item, parent, false))
    }

    override fun getItemCount() = matchList.size

    override fun onBindViewHolder(holder: ScoresViewHolder, position: Int) {
        val match = matchList[position]

        holder.view.txtHomeTeam.text = match.homeTeam
        holder.view.txtAwayTeam.text = match.awayTeam
        holder.view.txtScore.text = match.homeScore + " - " + match.awayScore
    }

    class ScoresViewHolder constructor(val view: View) : RecyclerView.ViewHolder(view)
}