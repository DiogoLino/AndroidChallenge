package com.android.presentation.contacts

interface MarvelContactsView {

    fun onHeroesLoaded(heroes: List<UiHero>)
    fun onSquadLoaded(heroes: List<UiHero>)
    fun hideLoading()
    fun showLoading()
}