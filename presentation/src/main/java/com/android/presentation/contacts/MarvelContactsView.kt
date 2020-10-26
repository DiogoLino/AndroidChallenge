package com.android.presentation.contacts

import com.android.repository.contacts.models.Hero

interface MarvelContactsView {

    fun onHeroesLoaded(heroes: List<UiHero>)
    fun hideLoading()
    fun showLoading()
}