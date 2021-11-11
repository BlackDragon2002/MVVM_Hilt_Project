package com.example.mvvm_hilt_project.di

import com.example.mvvm_hilt_project.repository.MainRepository
import com.example.mvvm_hilt_project.retrofit.BlogRetrofit
import com.example.mvvm_hilt_project.retrofit.NetworkMapper
import com.example.mvvm_hilt_project.room.BlogDao
import com.example.mvvm_hilt_project.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        blogRetrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ):MainRepository=
        MainRepository(
            blogDao,
            blogRetrofit,
            cacheMapper,
            networkMapper
        )
}