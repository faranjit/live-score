package com.faranjit.livescore.features.news.presenter

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.faranjit.livescore.R
import com.faranjit.livescore.base.BaseFragment
import com.faranjit.livescore.features.newsdetail.NewsDetailActivity
import com.faranjit.livescore.model.NewsItem
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsFragment : BaseFragment(), NewsContract.View {

    @Inject
    lateinit var presenter: NewsContract.Presenter

    companion object {
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        initView()
    }

    override fun provideLayoutResId() = R.layout.fragment_news

    override fun loadNewsSuccess(news: List<NewsItem>?) {
        recyclerNews.layoutManager = LinearLayoutManager(context)
        recyclerNews.adapter = NewsAdapter(requireContext(), news!!) {
            startActivity(NewsDetailActivity.newIntent(requireContext(), it.link))
        }
    }

    private fun initView() {
        presenter.loadNews()
    }
}