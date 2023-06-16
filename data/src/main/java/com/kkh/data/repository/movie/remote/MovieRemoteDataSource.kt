package com.kkh.data.repository.movie.remote

import com.kkh.data.di.manager.remote.NetworkResponse
import com.kkh.data.model.MovieModel

interface MovieRemoteDataSource {

    suspend fun getSearchMovies(query: String, start: Int = 1): NetworkResponse<List<MovieModel>>

}