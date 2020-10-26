package com.android.presentation.details

import com.android.presentation.contacts.UiHero

interface HeroContactDetailsView {

    fun onSquadMemberDeleted(heroes: List<UiHero>)

    fun onSquadMemberAdded(heroes: List<UiHero>)
}