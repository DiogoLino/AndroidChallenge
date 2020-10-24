package com.android.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


private const val FIFTEEN = 15L
private const val TWENTY = 20L

const val API_BASE_URL = "https://gateway.marvel.com/v1/public/"

@Module
open class ApiModule {

    private val authApi: AuthApi = AuthApi()

    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideGsonFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun client(
        requestInterceptor: Interceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(FIFTEEN, TimeUnit.SECONDS)
            .readTimeout(TWENTY, TimeUnit.SECONDS)
            .writeTimeout(FIFTEEN, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(requestInterceptor)
            .build()
    }

    @Provides
    @Singleton
    open fun provideMarvelApiService(retrofit: Retrofit): MarvelApiService {
        return retrofit.create(MarvelApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRestAdapter(
        factory: GsonConverterFactory,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideRequestInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val url = buildUrlFrom(chain)
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()

    }

    protected open fun buildUrlFrom(chain: Interceptor.Chain): HttpUrl {
        return buildQueryParameters(chain).build()
    }

    private fun buildQueryParameters(chain: Interceptor.Chain): HttpUrl.Builder {
        return chain.request()
            .url
            .newBuilder()
            .addQueryParameter("ts", authApi.timeStamp)
            .addQueryParameter("apikey", authApi.publicKey)
            .addQueryParameter("hash", authApi.md5Key)
    }
}

