package com.android.base_di

import dagger.android.AndroidInjector
import javax.inject.Provider

interface FeatureComponent : BaseComponent {
    val bindings: Map<Class<*>, Provider<AndroidInjector.Factory<*>>>
}