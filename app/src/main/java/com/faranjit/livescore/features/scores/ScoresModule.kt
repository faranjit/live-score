package com.faranjit.livescore.features.scores

import com.faranjit.livescore.api.RssApi
import com.faranjit.livescore.features.scores.data.ScoresDataRepository
import com.faranjit.livescore.features.scores.data.ScoresDataSource
import com.faranjit.livescore.features.scores.domain.GetScores
import com.faranjit.livescore.features.scores.domain.ScoresRepository
import com.faranjit.livescore.features.scores.presenter.ScoresContract
import com.faranjit.livescore.features.scores.presenter.ScoresPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Bulent Turkmen on 2019-05-27.
 */
@Module
class ScoresModule {
    @Provides
    fun provideScoresContract(): ScoresContract = ScoresContract()

    @Provides
    fun provideScoresPresenter(contract: ScoresContract, getScores: GetScores): ScoresContract.Presenter =
        ScoresPresenter(contract, getScores)

    @Provides
    fun provideScoresDataSource(retrofit: Retrofit): ScoresDataSource =
        ScoresDataSource(retrofit.create(RssApi::class.java))

    @Provides
    fun provideScoresRepository(newsDataSource: ScoresDataSource): ScoresRepository =
        ScoresDataRepository(newsDataSource)
}