package com.faranjit.livescore

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.faranjit.livescore.di.component.ApplicationComponent
import com.faranjit.livescore.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
class LSApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {
    public lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var actInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
        applicationComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = actInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = mFragmentInjector
}