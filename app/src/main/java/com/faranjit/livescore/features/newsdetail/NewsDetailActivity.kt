package com.faranjit.livescore.features.newsdetail

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import com.faranjit.livescore.R
import com.faranjit.livescore.base.BaseActivity
import com.faranjit.livescore.features.newsdetail.presenter.NewsDetailContract
import kotlinx.android.synthetic.main.fragment_news_detail.*

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class NewsDetailActivity : BaseActivity(), NewsDetailContract.View {

    companion object {
        private const val URL_KEY = "news_url"

        fun newIntent(context: Context, url: String): Intent {
            val bundle = Bundle()
            bundle.putString(URL_KEY, url)

            val intent = Intent(context, NewsDetailActivity::class.java)
            intent.putExtras(bundle)

            return intent
        }
    }

    override fun provideLayoutResId() = R.layout.fragment_news_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settings = webView.settings
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setAppCachePath(cacheDir.path)
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = true
        settings.textZoom = 125
        settings.blockNetworkImage = false
        settings.loadsImagesAutomatically = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.mediaPlaybackRequiresUserGesture = false
        settings.domStorageEnabled = true
        settings.setSupportMultipleWindows(true)
        settings.loadWithOverviewMode = true
        settings.allowContentAccess = true
        settings.setGeolocationEnabled(true)
        settings.allowUniversalAccessFromFileURLs = true
        settings.allowFileAccess = true
        webView.fitsSystemWindows = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true  // api 26
        }

        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webView.loadUrl(intent?.getStringExtra(URL_KEY))
    }

    override fun loadDetailSuccess() {

    }
}