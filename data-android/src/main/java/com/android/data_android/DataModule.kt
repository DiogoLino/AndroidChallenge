package com.android.data_android

import com.android.api.contacts.ApiHeroContactsSourceImpl
import com.android.database.data_source.DbHeroContactsDbDataSourceImpl
import com.android.domain.PostExecutionThread
import com.android.repository.contacts.data_source.HeroContactsApiDataSource
import com.android.repository.contacts.data_source.HeroContactsDbDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun heroContactsApiDataSource(impl: ApiHeroContactsSourceImpl): HeroContactsApiDataSource

    @Binds
    abstract fun heroContactsDbDataSource(impl: DbHeroContactsDbDataSourceImpl): HeroContactsDbDataSource


    @Binds
    abstract fun postExecutionThread(impl: UIThread): PostExecutionThread

}


