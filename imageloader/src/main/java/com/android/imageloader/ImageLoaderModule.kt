package com.android.imageloader

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageLoaderModule {

    @Provides
    @Singleton
    fun requestManager(context: Context): RequestManager {
        return Glide.with(context)
    }

    @Provides
    @Singleton
    fun bitmapPool(context: Context): BitmapPool {
        return Glide.get(context).bitmapPool
    }

    @Provides
    @Singleton
    fun provideImageLoader(
        glideRequestManager: RequestManager
    ): ImageLoader {
        return ImageLoaderImp(glideRequestManager)
    }
}
