package com.faranjit.livescore.features.dashboard.presenter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.faranjit.livescore.R
import com.faranjit.livescore.base.BaseActivity
import com.faranjit.livescore.features.news.presenter.NewsFragment
import com.faranjit.livescore.features.scores.presenter.ScoresFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        spinnerOptions.adapter = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_dropdown_item,
            arrayListOf("News", "Scores")
        )

        spinnerOptions.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) {
                    navigateToFragment(NewsFragment.newInstance(), supportFragmentManager, "news")
                } else if (position == 1) {
                    navigateToFragment(ScoresFragment.newInstance(), supportFragmentManager, "scores")
                }
            }

        }
    }

    override fun provideLayoutResId() = R.layout.activity_main

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
