package com.android.androidchallenge.ui.details

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.androidchallenge.R
import com.android.androidchallenge.di.inject
import com.android.androidchallenge.ui.adapters.BaseMarvelActivity
import com.android.androidchallenge.ui.home.HERO_ARGS_KEY
import com.android.androidchallenge.utils.STANDARD_FANTASTIC
import com.android.imageloader.ImageLoader
import com.android.presentation.contacts.UiHero
import com.android.presentation.details.HeroContactDetailsView
import javax.inject.Inject

class HeroDetailsActivity : BaseMarvelActivity(), HeroContactDetailsView {

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var heroPoster: ImageView
    private lateinit var heroName: TextView
    private lateinit var heroDescription: TextView
    private lateinit var addButton: Button
    private lateinit var deleteButton: Button

    private val uiHero: UiHero by lazy { intent.getParcelableExtra<UiHero>(HERO_ARGS_KEY) as UiHero }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        populateViews()
    }

    private fun initViews() {
        heroPoster = findViewById(R.id.hero_poster)
        heroName = findViewById(R.id.hero_name)
        heroDescription = findViewById(R.id.hero_description)
        addButton = findViewById(R.id.addButton)
        deleteButton = findViewById(R.id.delete_button)
    }

    private fun populateViews() {
        imageLoader.load(
            uiHero.getThumbnail(STANDARD_FANTASTIC),
            heroPoster,
            R.drawable.user_avatar_placeholder
        )
        heroName.text = uiHero.name
        heroDescription.text = uiHero.description
    }

    override fun setContentView() {
        setContentView(R.layout.hero_detail_activity)
    }

    override fun inject() {
        inject(this)
    }

    override fun onSquadMemberDeleted(heroes: List<UiHero>) {

    }

    override fun onSquadMemberAdded(heroes: List<UiHero>) {

    }


}