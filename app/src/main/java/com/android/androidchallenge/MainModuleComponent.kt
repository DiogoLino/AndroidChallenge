package com.android.androidchallenge

import com.android.base_di.AppComponent
import com.android.base_di.FeatureComponent
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Provider
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MainModule

@MainModule
@Component(
    modules = [
        AndroidInjectionModule::class
    ],
    dependencies = [AppComponent::class]
)
interface MainModuleComponent : FeatureComponent {

    fun inject(marvelApplication: MarvelApplication)

    @MainModule
    override val bindings: Map<Class<*>, Provider<AndroidInjector.Factory<*>>>
}
