package com.kkh.data.di.module.repository

import com.kkh.data.repository.MovieRepositoryImpl
import com.kkh.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsMovieRepository(implements: MovieRepositoryImpl): MovieRepository
}