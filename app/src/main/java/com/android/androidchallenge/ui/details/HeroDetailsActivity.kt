package com.android.androidchallenge.ui.details

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.android.androidchallenge.R
import com.android.androidchallenge.di.inject
import com.android.androidchallenge.ui.BaseMarvelActivity
import com.android.androidchallenge.ui.dialog.DetailsDialog
import com.android.androidchallenge.ui.home.HERO_ARGS_KEY
import com.android.androidchallenge.utils.*
import com.android.imageloader.ImageLoader
import com.android.presentation.contacts.UiHero
import com.android.presentation.details.HeroContactDetailsView
import com.android.presentation.details.HeroDetailPresenter
import javax.inject.Inject

class HeroDetailsActivity : BaseMarvelActivity(), HeroContactDetailsView {

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var presenter: HeroDetailPresenter

    private lateinit var heroPoster: ImageView
    private lateinit var heroName: TextView
    private lateinit var heroDescription: TextView
    private lateinit var addButton: Button
    private lateinit var removeButton: Button
    private lateinit var dialog: DetailsDialog
    private var showSquadMemberButton: Boolean = false
    private val uiHero: UiHero by lazy { intent.getParcelableExtra<UiHero>(HERO_ARGS_KEY) as UiHero }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        initViews()
        populateViews()
    }

    private fun initViews() {
        heroPoster = findViewById(R.id.hero_poster)
        heroName = findViewById(R.id.hero_name)
        heroDescription = findViewById(R.id.hero_description)
        addButton = findViewById(R.id.addButton)
        removeButton = findViewById(R.id.removeButton)
    }

    private fun populateViews() {
        showSquadMemberButton = uiHero.squadMember
        imageLoader.load(
            uiHero.getThumbnail(STANDARD_FANTASTIC),
            heroPoster,
            R.drawable.user_avatar_placeholder
        )
        heroName.text = uiHero.name
        heroDescription.text = uiHero.description
        removeButton.text = getString(R.string.remove_button_text, getEmoji(FIRE_EMOJI))
        addButton.text = getString(R.string.add_button_text, getEmoji(FLEX_EMOJI))
        updateButton()
        dialog = DetailsDialog.newInstance(uiHero.name) { presenter.removeHeroFromSquad(uiHero) }
        addButton.setOnClickListener { presenter.addHeroToSquad(uiHero) }
        removeButton.setOnClickListener { dialog.show(supportFragmentManager, "detail_Dialog") }
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = null
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun setContentView() {
        setContentView(R.layout.hero_detail_activity)
    }

    override fun inject() {
        inject(this)
    }

    override fun onSquadMemberRemoved() {
        showSquadMemberButton = false
        updateButton()
        setResult(Activity.RESULT_OK)
    }

    override fun onSquadMemberAdded() {
        showSquadMemberButton = true
        updateButton()
        setResult(Activity.RESULT_OK)
    }

    private fun updateButton() {
        if (showSquadMemberButton) {
            removeButton.visible()
            addButton.gone()
        } else {
            addButton.visible()
            removeButton.gone()
        }
    }
}