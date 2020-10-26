package com.android.androidchallenge.di

import com.android.androidchallenge.ui.home.HeroesActivity
import com.android.base_di.ActivityComponent
import com.android.base_di.AppComponent
import com.android.base_di.appComponent
import com.android.presentation.contacts.MarvelContactsView
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MarvelContactsModule::class])
interface HeroesComponent : ActivityComponent<HeroesActivity> {

    @Component.Builder
    interface Builder {
        fun appComponent(component: AppComponent): Builder

        @BindsInstance
        fun activity(activity: HeroesActivity): Builder

        fun build(): HeroesComponent
    }
}

fun inject(activity: HeroesActivity) {
    DaggerHeroesComponent.builder()
        .appComponent(activity.appComponent)
        .activity(activity)
        .build()
        .inject(activity)
}

@Module
abstract class MarvelContactsModule {
    @Binds
    abstract fun marvelContactsView(impl: HeroesActivity): MarvelContactsView
}