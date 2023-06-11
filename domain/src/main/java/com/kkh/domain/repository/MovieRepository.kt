package com.kkh.domain.repository

import com.kkh.domain.model.Movie

interface MovieRepository {

    fun getMovies(query: String): List<Movie>
}