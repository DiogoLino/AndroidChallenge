package com.android.androidchallenge.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.androidchallenge.R
import com.android.androidchallenge.di.inject
import com.android.androidchallenge.ui.adapters.BaseMarvelActivity
import com.android.androidchallenge.ui.adapters.HeroesAdapter
import com.android.androidchallenge.ui.details.HeroDetailsActivity
import com.android.imageloader.ImageLoader
import com.android.presentation.contacts.MarvelContactsPresenter
import com.android.presentation.contacts.MarvelContactsView
import com.android.presentation.contacts.UiHero
import javax.inject.Inject

const val HERO_ARGS_KEY = "hero_args_key"
const val HERO_ACTIVITY_REQUEST_CODE = 105

class HeroesActivity : BaseMarvelActivity(), MarvelContactsView {

    @Inject
    lateinit var presenter: MarvelContactsPresenter

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var heroesRecyclerView: RecyclerView
    private lateinit var squadRecyclerView: RecyclerView
    private lateinit var squadContainer: LinearLayout
    private lateinit var heroesAdapter: HeroesAdapter

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

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
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
        heroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HeroesActivity)
            adapter = heroesAdapter
        }

    }

    fun initSquadAdapter(heroes: List<UiHero>) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun initHeroesAdapter(heroes: List<UiHero>) {
        heroesAdapter = HeroesAdapter(this, heroes, imageLoader) { onHeroClicked(it) }
    }

    private fun onHeroClicked(hero: UiHero) {
        val intent = Intent(this, HeroDetailsActivity::class.java)
        intent.putExtra(HERO_ARGS_KEY, hero)
        this.startActivityForResult(intent, HERO_ACTIVITY_REQUEST_CODE)
    }

    override fun hideLoading() {

    }

    override fun showLoading() {

    }
}