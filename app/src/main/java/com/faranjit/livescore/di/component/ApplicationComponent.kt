package com.faranjit.livescore.di.component

import com.faranjit.livescore.LSApplication
import com.faranjit.livescore.di.module.ActivityBuilder
import com.faranjit.livescore.di.module.LoggerModule
import com.faranjit.livescore.di.module.NetworkModule
import com.faranjit.livescore.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import timber.log.Timber

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
@ApplicationScope
@Component(modules = arrayOf(NetworkModule::class, LoggerModule::class, ActivityBuilder::class))
interface ApplicationComponent {
    fun inject(application: LSApplication)

    fun provideRetrofit(): Retrofit

    fun provideLogTree(): Timber.Tree

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: LSApplication): Builder

        fun build(): ApplicationComponent
    }
}