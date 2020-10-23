package com.android.base_di

interface ComponentProvider {

    @JvmSuppressWildcards
    operator fun <T : BaseComponent> get(type: Class<out T>): T
}
