package com.kkh.data.di.module.repository

import com.kkh.data.repository.location.remote.LocationRemoteDataSource
import com.kkh.data.repository.location.remote.LocationRemoteDataSourceImpl
import com.kkh.data.repository.movie.remote.MovieRemoteDataSource
import com.kkh.data.repository.movie.remote.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {

    @Singleton
    @Binds
    fun bindsMovieRemoteDataSource(implements: MovieRemoteDataSourceImpl): MovieRemoteDataSource

    @Singleton
    @Binds
    fun bindsLocationRemoteDataSource(implements: LocationRemoteDataSourceImpl): LocationRemoteDataSource
}