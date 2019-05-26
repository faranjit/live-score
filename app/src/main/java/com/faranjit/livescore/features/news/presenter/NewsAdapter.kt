package com.faranjit.livescore.features.news.presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faranjit.livescore.R
import com.faranjit.livescore.di.module.GlideApp
import com.faranjit.livescore.model.NewsItem
import kotlinx.android.synthetic.main.layout_news_item.view.*

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsAdapter(
    val context: Context,
    val newsList: List<NewsItem>,
    val newsClickListener: (newsItem: NewsItem) -> (Unit)) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_news_item, parent, false))
    }

    override fun getItemCount() = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = newsList[position]

        holder.view.newsTitle.text = newsItem.title
        holder.view.newsDate.text = newsItem.pubDate
        GlideApp.with(context).load(newsItem.enclosure?.url).into(holder.view.newsImage)

        holder.view.setOnClickListener {
            newsClickListener(newsItem)
        }
    }

    class NewsViewHolder constructor(val view: View) : RecyclerView.ViewHolder(view)
}