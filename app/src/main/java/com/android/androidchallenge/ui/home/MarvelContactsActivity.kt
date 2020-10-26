package com.android.androidchallenge.ui.home

import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.androidchallenge.R
import com.android.androidchallenge.di.inject
import com.android.androidchallenge.ui.adapters.BaseMarvelActivity
import com.android.presentation.contacts.MarvelContactsPresenter
import com.android.presentation.contacts.MarvelContactsView
import com.android.presentation.contacts.UiHero
import com.android.repository.contacts.models.Hero
import javax.inject.Inject

class MarvelContactsActivity : BaseMarvelActivity(), MarvelContactsView {

    @Inject
    lateinit var presenter: MarvelContactsPresenter

    private lateinit var heroesRecyclerView: RecyclerView
    private lateinit var squadRecyclerView: RecyclerView
    private lateinit var squadContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        loadHeroContacts()
    }

    private fun initView() {
        heroesRecyclerView = findViewById(R.id.heroes_recycler_view)
        squadRecyclerView = findViewById(R.id.squad_recycler_view)
        squadContainer = findViewById(R.id.squad_container)
    }


    private fun loadHeroContacts() {
        presenter.loadHeroContacts()
    }

    override fun setContentView() {
        setContentView(R.layout.heroes_activity)
    }

    override fun inject() {
        inject(this)
    }

    override fun onHeroesLoaded(heroes: List<UiHero>) {
        populateViews(heroes)
    }

    private fun populateViews(heroes: List<UiHero>) {
        //check if needs to show squad
       initHeroesAdapter(heroes)

    }

    fun initSquadAdapter(heroes: List<UiHero>) {

    }


    private fun initHeroesAdapter(heroes: List<UiHero>) {

    }

    override fun hideLoading() {

    }

    override fun showLoading() {

    }
}