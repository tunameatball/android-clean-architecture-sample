package com.kkh.data.repository

import com.kkh.domain.model.Movie
import com.kkh.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : MovieRepository {

    override fun getMovies(): List<Movie> {
        TODO("Not yet implemented")
    }
}