package com.kkh.data.repository.movie.remote

import com.kkh.data.model.MovieModel
import kotlinx.coroutines.flow.StateFlow

interface MovieRemoteDataSource {

    fun getSearchMovies(query: String, start: Int = 1): StateFlow<List<MovieModel>>

}