package com.android.api

import com.android.repository.Heroes
import io.reactivex.Observable
import retrofit2.http.GET


interface MarvelApiService {

    @GET("/v1/public/characters")
    fun loadHeroes(
    ): Observable<Heroes>

}