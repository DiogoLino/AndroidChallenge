package com.android.androidchallenge.ui

import android.os.Bundle
import com.android.androidchallenge.R
import com.android.androidchallenge.di.inject
import com.android.presentation.contacts.MarvelContactsPresenter
import com.android.presentation.contacts.MarvelContactsView
import com.android.repository.Heroes
import timber.log.Timber
import javax.inject.Inject

class MarvelContactsActivity : BaseMarvelActivity(), MarvelContactsView {

    @Inject
    lateinit var presenter: MarvelContactsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadHeroContacts()
    }

    private fun loadHeroContacts() {
        presenter.loadHeroContacts()
    }

    override fun setContentView() {
        setContentView(R.layout.activity_main)
    }

    override fun inject() {
        inject(this)
    }

    override fun onHeroesLoaded(heroes: Heroes) {
        Timber.d("HEROES",heroes)
    }

    override fun hideLoading() {

    }

    override fun showLoading() {

    }
}