package com.kkh.data.repository.location.remote

import com.kkh.data.api.LocationApi
import com.kkh.data.di.manager.remote.request
import com.kkh.data.model.LocationResponse
import com.kkh.data.util.const.API_GET_LOCATION
import javax.inject.Inject

class LocationRemoteDataSourceImpl @Inject constructor(
    private val locationApi: LocationApi

) : LocationRemoteDataSource {

    override suspend fun getLocations(query: String): LocationResponse? {
        return request(
            api = API_GET_LOCATION,
            call = locationApi.getLocation(
                query = query
            )
        )
    }
}