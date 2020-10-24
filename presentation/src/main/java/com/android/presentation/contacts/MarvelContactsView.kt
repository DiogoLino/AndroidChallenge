package com.android.presentation.contacts

import com.android.repository.contacts.models.Heroes

interface MarvelContactsView {

    fun onHeroesLoaded(heroes: List<Heroes>)
    fun hideLoading()
    fun showLoading()
}