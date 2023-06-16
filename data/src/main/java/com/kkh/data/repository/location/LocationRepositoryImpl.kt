package com.kkh.data.repository.location

import com.kkh.data.repository.location.remote.LocationRemoteDataSource
import com.kkh.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationRemoteDataSource: LocationRemoteDataSource
) : LocationRepository {

    override suspend fun getLocation(query: String) {
        TODO("Not yet implemented")
    }
}