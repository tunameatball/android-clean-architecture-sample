package com.kkh.data.repository.location.remote

import com.kkh.data.api.LocationApi
import com.kkh.data.di.manager.remote.NetworkResponse
import com.kkh.data.model.LocationResponse
import javax.inject.Inject

class LocationRemoteDataSourceImpl @Inject constructor(
    private val locationApi: LocationApi

) : LocationRemoteDataSource {

    override suspend fun getLocations(query: String): NetworkResponse<LocationResponse> {
        return locationApi.getLocation(
            query = query
        )
    }
}