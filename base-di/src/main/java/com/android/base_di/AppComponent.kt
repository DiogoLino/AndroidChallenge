package com.android.base_di

import android.app.Application
import android.content.Context
import com.android.api.ApiModule
import com.android.data_android.DataModule
import com.android.database.MarvelDatabase
import com.android.database.RoomModule
import com.android.domain.PostExecutionThread
import com.android.imageloader.ImageLoader
import com.android.imageloader.ImageLoaderModule
import com.android.repository.RepositoryModule
import com.android.repository.contacts.HeroContactsRepository
import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        ApiModule::class,
        RoomModule::class,
        RepositoryModule::class,
        DataModule::class,
        ImageLoaderModule::class
    ]
)
@Singleton
interface AppComponent : BaseComponent {
    val okHttpClient: OkHttpClient
    val application: Application
    val marvelDatabase: MarvelDatabase
    val postExecutionThread: PostExecutionThread
    val context: Context
    val gson: Gson
    val heroContactsApiDataSource: HeroContactsApiDataSource
    val heroContactsDbDataSource: HeroContactsDbDataSource
    val heroesContactsRepository: HeroContactsRepository
    val imageLoader: ImageLoader

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(ctx: Context): Builder

        @BindsInstance
        fun bindApplication(ctx: Application): Builder

        fun apiModule(module: ApiModule): Builder
        fun build(): AppComponent
    }
}
