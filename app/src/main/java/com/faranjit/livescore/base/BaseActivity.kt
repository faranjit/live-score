package com.faranjit.livescore.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.faranjit.livescore.R
import dagger.android.AndroidInjection

/**
 * Created by Bulent Turkmen on 2019-05-26.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        setContentView(provideLayoutResId())
    }

    abstract fun provideLayoutResId(): Int

    fun navigateToFragment(fragment: Fragment, manager: FragmentManager, tag: String?) {
        manager.beginTransaction().replace(R.id.container, fragment, tag).commit()
    }
}