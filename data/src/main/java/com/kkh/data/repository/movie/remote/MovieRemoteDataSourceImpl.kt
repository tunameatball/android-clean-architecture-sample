package com.kkh.data.repository.movie.remote

import com.kkh.data.model.MovieModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(

) : MovieRemoteDataSource {
    override fun getSearchMovies(query: String, start: Int): StateFlow<List<MovieModel>> {
        TODO("Not yet implemented")
    }
}