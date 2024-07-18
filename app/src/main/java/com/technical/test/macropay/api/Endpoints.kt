package com.technical.test.macropay.api

import com.technical.test.macropay.api.response.ResponseListMovies
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Endpoints {
    @GET("3/movie/now_playing")
    suspend fun getListMovies(
        @Query("page") page: Int,
        @Header("Authorization") token: String
    ): ResponseListMovies
}