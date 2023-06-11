package com.kkh.data.api

import com.kkh.data.di.manager.remote.NetworkResponse
import com.kkh.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/v1/search/movie.json")
    suspend fun getMovie(
        @Query("query") query: String,
        @Query("start") start: Int = 1,
        @Query("display") display: Int = 15
    ): NetworkResponse<MovieResponse>
}