package com.android.data_android

import com.android.domain.PostExecutionThread
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

//    @Binds
//    abstract fun courseApiDataSource(impl: ApiCourseDataSourceImpl): CourseApiDataSource
//
//    @Binds
//    abstract fun friendApiDataSource(impl: FriendApiDataSourceImpl): FriendApiDataSource
//
//    @Binds
//    abstract fun userApiDataSource(impl: ApiUserDataSourceImpl): UserApiDataSource
//
//    @Binds
//    abstract fun vocabApiDataSource(impl: VocabApiDataSourceImpl): VocabApiDataSource
//
//    @Binds
//    abstract fun progressApiDataSource(impl: ProgressApiDataSourceImpl): ProgressApiDataSource

    @Binds
    abstract fun postExecutionThread(impl: UIThread): PostExecutionThread

}


