package com.faranjit.livescore.di.module

import com.faranjit.livescore.BuildConfig
import com.faranjit.livescore.base.ReleaseTree
import com.faranjit.livescore.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import timber.log.Timber

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
@Module
class LoggerModule {

    @Provides
    @ApplicationScope
    internal fun provideTimberTree(): Timber.Tree {
        val timberTree: Timber.Tree
        if (BuildConfig.DEBUG) {
            timberTree = Timber.DebugTree()
        } else {
            timberTree = ReleaseTree()
        }

        return timberTree
    }
}