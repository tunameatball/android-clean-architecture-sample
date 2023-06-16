package com.kkh.data.api

import com.kkh.data.di.manager.remote.NetworkResponse
import com.kkh.data.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {

    @GET("/v1/search/local.json")
    suspend fun getLocation(
        @Query("query") query: String,
        @Query("display") display: Int = 5
    ): NetworkResponse<LocationResponse>
}