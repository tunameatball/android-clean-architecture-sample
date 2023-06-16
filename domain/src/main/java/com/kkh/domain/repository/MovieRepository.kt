package com.kkh.domain.repository

import com.kkh.domain.model.Movie

interface MovieRepository {

    suspend fun getMovies(query: String): List<Movie>
}