package com.android.presentation.contacts

import com.android.repository.Heroes

interface MarvelContactsView {

    fun onHeroesLoaded(heroes: Heroes)
    fun hideLoading()
    fun showLoading()
}