package com.faranjit.livescore.di.module

import com.faranjit.livescore.features.dashboard.DashboardModule
import com.faranjit.livescore.features.dashboard.presenter.MainActivity
import com.faranjit.livescore.features.news.NewsModule
import com.faranjit.livescore.features.news.presenter.NewsFragment
import com.faranjit.livescore.features.newsdetail.NewsDetailActivity
import com.faranjit.livescore.features.newsdetail.NewsDetailModule
import com.faranjit.livescore.features.scores.ScoresModule
import com.faranjit.livescore.features.scores.presenter.ScoresFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [DashboardModule::class])
    internal abstract fun bindDashboardctivity(): MainActivity

    @ContributesAndroidInjector(modules = [NewsModule::class])
    internal abstract fun bindNewsFragment(): NewsFragment

    @ContributesAndroidInjector(modules = [ScoresModule::class])
    internal abstract fun bindScoreFragment(): ScoresFragment

    @ContributesAndroidInjector(modules = [NewsDetailModule::class])
    internal abstract fun bindNewsDetailActivity(): NewsDetailActivity
}