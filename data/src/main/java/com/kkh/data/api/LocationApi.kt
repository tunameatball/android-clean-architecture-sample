package com.kkh.data.api

import com.kkh.data.model.LocationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {

    @GET("/v1/search/local.json")
    fun getLocation(
        @Query("query") query: String,
        @Query("display") display: Int = 5
    ): Call<LocationResponse>
}