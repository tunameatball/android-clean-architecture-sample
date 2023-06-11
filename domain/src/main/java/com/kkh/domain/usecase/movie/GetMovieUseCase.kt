package com.kkh.domain.usecase.movie

import com.kkh.domain.common.Resource
import com.kkh.domain.model.Movie
import com.kkh.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetMovieUseCase(
    private val repository: MovieRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getMovies(query)
            emit(Resource.Success(result))
        } catch (e: IOException) {
            emit(Resource.Error("Offline"))
        }
    }
}