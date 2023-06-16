package com.kkh.domain.repository

interface LocationRepository {

    suspend fun getLocation(query: String)
}