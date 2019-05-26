package com.faranjit.livescore.features.news.domain

import com.faranjit.livescore.base.RequestUseCase
import com.faranjit.livescore.model.News
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class GetNews @Inject constructor(val newsRepository: NewsRepository) : RequestUseCase<News, Unit>() {

    override fun buildUseCaseObservable(params: Unit): Single<News> = newsRepository.getNews()
}