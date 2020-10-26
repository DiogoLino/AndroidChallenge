package com.android.androidchallenge.di

import com.android.androidchallenge.ui.details.HeroDetailsActivity
import com.android.base_di.ActivityComponent
import com.android.base_di.AppComponent
import com.android.base_di.appComponent
import com.android.presentation.details.HeroContactDetailsView
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [HeroDetailsModule::class])
interface HeroesDetailsComponent : ActivityComponent<HeroDetailsActivity> {

    @Component.Builder
    interface Builder {
        fun appComponent(component: AppComponent): Builder

        @BindsInstance
        fun activity(activity: HeroDetailsActivity): Builder

        fun build(): HeroesDetailsComponent
    }
}

fun inject(activity: HeroDetailsActivity) {
    DaggerHeroesDetailsComponent.builder()
        .appComponent(activity.appComponent)
        .activity(activity)
        .build()
        .inject(activity)
}

@Module
abstract class HeroDetailsModule {
    @Binds
    abstract fun heroContactDetailView(impl: HeroDetailsActivity): HeroContactDetailsView
}