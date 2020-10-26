package com.android.api

import com.android.api.contacts.model.ApiBaseMarvel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

private const val ORDER_BY_NAME = "name"

interface MarvelApiService {

    @GET("/v1/public/characters")
    fun loadHeroes(
        @Query("offset") offset: Int,
        @Query("orderBy") orderBy: String = ORDER_BY_NAME
    ): Observable<ApiBaseMarvel>


}