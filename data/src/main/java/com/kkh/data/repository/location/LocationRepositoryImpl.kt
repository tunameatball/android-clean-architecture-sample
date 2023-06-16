package com.kkh.data.repository.location

import android.util.Log
import com.kkh.data.di.manager.remote.NetworkResponse
import com.kkh.data.mapper.toLocation
import com.kkh.data.repository.location.remote.LocationRemoteDataSource
import com.kkh.domain.model.Location
import com.kkh.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationRemoteDataSource: LocationRemoteDataSource
) : LocationRepository {

    override suspend fun getLocation(query: String): List<Location> {
        Log.i("LocationRepositoryImpl", "getLocation")
        return when (val result = locationRemoteDataSource.getLocations(query)) {
            is NetworkResponse.Success -> {
                result.body?.items?.map { it.toLocation() }.orEmpty()
            }

            else -> emptyList<Location>()
        }
    }
}