package com.kkh.data.repository.location.remote

import com.kkh.data.model.LocationResponse

interface LocationRemoteDataSource {

    suspend fun getLocations(query: String): LocationResponse?

}