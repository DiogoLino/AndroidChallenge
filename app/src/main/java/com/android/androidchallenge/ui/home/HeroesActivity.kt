package com.android.androidchallenge.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.androidchallenge.R
import com.android.androidchallenge.di.inject
import com.android.androidchallenge.ui.BaseMarvelActivity
import com.android.androidchallenge.ui.adapters.EndlessRecyclerViewScrollListener
import com.android.androidchallenge.ui.adapters.HeroesAdapter
import com.android.androidchallenge.ui.adapters.SquadAdapter
import com.android.androidchallenge.ui.details.HeroDetailsActivity
import com.android.androidchallenge.utils.gone
import com.android.androidchallenge.utils.visible
import com.android.imageloader.ImageLoader
import com.android.presentation.contacts.MarvelContactsPresenter
import com.android.presentation.contacts.MarvelContactsView
import com.android.presentation.contacts.UiHero
import javax.inject.Inject

const val HERO_ARGS_KEY = "hero_args_key"
const val HERO_ACTIVITY_REQUEST_CODE = 105

const val VISIBLE_THRESHOLD = 50
const val FIRST_PAGE = 0

class HeroesActivity : BaseMarvelActivity(), MarvelContactsView {

    @Inject
    lateinit var presenter: MarvelContactsPresenter

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var heroesRecyclerView: RecyclerView
    private lateinit var squadRecyclerView: RecyclerView
    private lateinit var squadContainer: LinearLayout
    private lateinit var loadingView: ProgressBar
    private var heroesAdapter: HeroesAdapter? = null
    private var squadAdapter: SquadAdapter? = null
    private lateinit var scrollListener: EndlessRecyclerViewScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initHeroesAdapter()
        initHeroRecycler()
        loadHeroContacts()
        loadSquad()
    }

    private fun initView() {
        heroesRecyclerView = findViewById(R.id.heroes_recycler_view)
        squadRecyclerView = findViewById(R.id.squad_recycler_view)
        squadContainer = findViewById(R.id.squad_container)
        loadingView = findViewById(R.id.loading_view)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun loadHeroContacts() {
        presenter.loadHeroContacts(FIRST_PAGE)
    }

    private fun loadSquad() {
        presenter.loadSquad()
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

    override fun onSquadLoaded(heroes: List<UiHero>) {
        //check if needs to show squad
        if (heroes.isNotEmpty()) {
            populateSquad(heroes)
        }else{
            squadContainer.gone()
        }
    }

    private fun populateViews(heroes: List<UiHero>) {
        heroesAdapter?.addHeroes(heroes)
    }

    private fun populateSquad(heroes: List<UiHero>) {
        squadContainer.visible()
        squadAdapter = SquadAdapter(this, heroes, imageLoader) { onHeroClicked(it) }
        squadRecyclerView.apply {
            adapter = squadAdapter
            layoutManager =
                LinearLayoutManager(this@HeroesActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun initHeroRecycler() {
        val heroRecyclerLayoutManager = LinearLayoutManager(this@HeroesActivity)

        heroesRecyclerView.apply {
            adapter = heroesAdapter
            layoutManager = heroRecyclerLayoutManager
        }
        scrollListener = object : EndlessRecyclerViewScrollListener(
            heroRecyclerLayoutManager, VISIBLE_THRESHOLD
        ) {
            override fun onLoadMore(
                page: Int,
                totalItemsCount: Int,
                view: RecyclerView?
            ) {
                if (shouldLoadMore(page)) {
                    requestNextPage(page)
                }
            }
        }
        heroesRecyclerView.addOnScrollListener(scrollListener)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == HERO_ACTIVITY_REQUEST_CODE) {
            when (resultCode) {
                Activity.RESULT_OK -> {
                    refreshPage()
                    scrollListener.resetState()
                }
            }
        }
    }

    private fun refreshPage() {
        heroesAdapter?.refreshAdapter()
        presenter.loadHeroContacts(FIRST_PAGE)
        presenter.loadSquad()
    }

    fun shouldLoadMore(page: Int): Boolean {
        return page != FIRST_PAGE
    }

    fun requestNextPage(page: Int) {
        presenter.loadHeroContacts(page)
    }

    private fun initHeroesAdapter() {
        heroesAdapter = HeroesAdapter(imageLoader) { onHeroClicked(it) }
    }

    private fun onHeroClicked(hero: UiHero) {
        val intent = Intent(this, HeroDetailsActivity::class.java)
        intent.putExtra(HERO_ARGS_KEY, hero)
        this.startActivityForResult(intent, HERO_ACTIVITY_REQUEST_CODE)
    }

    override fun hideLoading() {
        loadingView.gone()
    }

    override fun showLoading() {
        loadingView.visible()
    }
}