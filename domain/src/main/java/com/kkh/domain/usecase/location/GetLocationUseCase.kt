package com.kkh.domain.usecase.location

import com.kkh.domain.common.Resource
import com.kkh.domain.model.Location
import com.kkh.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLocationUseCase(
    private val repository: LocationRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Location>>> = flow {
        

    }
}