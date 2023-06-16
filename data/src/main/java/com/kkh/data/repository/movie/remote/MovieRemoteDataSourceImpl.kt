package com.kkh.data.repository.movie.remote

import com.kkh.data.api.MovieApi
import com.kkh.data.di.manager.remote.NetworkResponse
import com.kkh.data.model.MovieModel
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    val movieApi: MovieApi
) : MovieRemoteDataSource {
    override suspend fun getSearchMovies(
        query: String,
        start: Int
    ): NetworkResponse<List<MovieModel>> {
        val response = movieApi.getMovie(
            query = query,
            start = start
        )

        return when (response) {
            is NetworkResponse.Success -> {
                NetworkResponse.Success(response.apiInfo, response.body?.items.orEmpty())
            }

            else -> response as NetworkResponse<List<MovieModel>>
        }
    }
}