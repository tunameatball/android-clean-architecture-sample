package com.kkh.domain.repository

import com.kkh.domain.model.Location

interface LocationRepository {

    suspend fun getLocation(query: String): List<Location>
}