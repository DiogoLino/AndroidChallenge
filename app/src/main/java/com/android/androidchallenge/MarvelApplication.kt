package com.android.androidchallenge

import android.app.Application
import com.android.base_di.*
import com.android.domain.ApplicationSubscriptionHolder
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import okhttp3.OkHttpClient
import java.util.*

/**
 * Android Application.
 */
class MarvelApplication : Application(), HasAndroidInjector, ComponentProvider,
    OkHttpProvider {

    private lateinit var dispatchingInjector: DispatchingAndroidInjector<Any>
    lateinit var componentMap: MutableMap<Class<out BaseComponent>, BaseComponent>

    private val appComponent: AppComponent
        get() = componentMap[AppComponent::class.java] as AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    override val okHttpClient: OkHttpClient
        get() = appComponent.okHttpClient

    private fun initDagger() {
        val applicationComponent = initDefaultGraph()
        componentMap = HashMap()
        componentMap[AppComponent::class.java] = applicationComponent
        val mainModuleComponent = DaggerMainModuleComponent.builder()
            .appComponent(applicationComponent)
            .build()
        componentMap[MainModuleComponent::class.java] = mainModuleComponent
        mainModuleComponent.inject(this)

        createComponentsWith(applicationComponent)
    }

    private fun initDefaultGraph(): AppComponent {
        return DaggerAppComponent.builder()
            .bindContext(this)
            .bindApplication(this)
            .build()
    }

    private fun createComponentsWith(applicationComponent: AppComponent) {
        val mainModuleComponent = DaggerMainModuleComponent.builder()
            .appComponent(applicationComponent)
            .build()
        componentMap[MainModuleComponent::class.java] = mainModuleComponent

        createInjectors(
            mainModuleComponent
        )
    }

    private fun createInjectors(vararg components: FeatureComponent) {
        dispatchingInjector = merge(*components)
    }

    override fun <T : BaseComponent> get(type: Class<out T>): T {
        return componentMap[type] as T
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingInjector

    override fun onTerminate() {
        ApplicationSubscriptionHolder.unsubscribe()
        super.onTerminate()
    }
}
