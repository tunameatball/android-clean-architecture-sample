package com.kkh.data.di.module

import com.kkh.domain.repository.LocationRepository
import com.kkh.domain.repository.MovieRepository
import com.kkh.domain.usecase.location.GetLocationUseCase
import com.kkh.domain.usecase.movie.GetMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieUseCase(repository: MovieRepository): GetMovieUseCase =
        GetMovieUseCase(repository)

    @Provides
    @Singleton
    fun provideGetLocationUseCase(repository: LocationRepository): GetLocationUseCase =
        GetLocationUseCase(repository)
}