package com.kkh.domain.usecase.location

import android.util.Log
import com.kkh.domain.common.Resource
import com.kkh.domain.model.Location
import com.kkh.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLocationUseCase(
    private val repository: LocationRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Location>>> = flow {
        try {
            emit(Resource.Loading())
            Log.i("GetLocationUseCase", query)
            val result = repository.getLocation(query)
            Log.i("GetLocationUseCase", "success")
            emit(Resource.Success(result))
        } catch (e: Exception) {
            Log.e("GetLocationUseCase", e.message ?: "Error")
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}