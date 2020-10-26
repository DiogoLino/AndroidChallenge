package com.android.presentation.details

import com.android.domain.BaseCompletableObserver

class HeroDetailsRemoveObserver(
    private val detailsView: HeroContactDetailsView
) : BaseCompletableObserver() {


    override fun onComplete() {
        super.onComplete()
        detailsView.onSquadMemberRemoved()
    }


}
