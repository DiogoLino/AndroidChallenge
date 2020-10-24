package com.android.androidchallenge.di

import com.android.androidchallenge.ui.MarvelContactsActivity
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
interface MarvelContactsComponent : ActivityComponent<MarvelContactsActivity> {

    @Component.Builder
    interface Builder {
        fun appComponent(component: AppComponent): Builder

        @BindsInstance
        fun activity(activity: MarvelContactsActivity): Builder

        fun build(): MarvelContactsComponent
    }
}

fun inject(activity: MarvelContactsActivity) {
    DaggerMarvelContactsComponent.builder()
        .appComponent(activity.appComponent)
        .activity(activity)
        .build()
        .inject(activity)
}

@Module
abstract class MarvelContactsModule {
    @Binds
    abstract fun marvelContactsView(impl: MarvelContactsActivity): MarvelContactsView
}