package com.kkh.data.repository

import android.util.Log
import com.kkh.data.di.manager.remote.NetworkResponse
import com.kkh.data.mapper.toMovie
import com.kkh.data.repository.movie.remote.MovieRemoteDataSource
import com.kkh.domain.model.Movie
import com.kkh.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(query: String): List<Movie> {
        Log.e("MovieRepositoryImpl", "getMovies")
        return when (val result = movieRemoteDataSource.getSearchMovies(query)) {
            is NetworkResponse.Success -> {
                result.body?.map {
                    it.toMovie()
                }.orEmpty()
            }

            else -> emptyList<Movie>()
        }
    }
}