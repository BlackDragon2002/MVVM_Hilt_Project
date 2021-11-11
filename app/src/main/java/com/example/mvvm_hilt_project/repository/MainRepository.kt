package com.example.mvvm_hilt_project.repository

import com.example.mvvm_hilt_project.model.Blog
import com.example.mvvm_hilt_project.retrofit.BlogRetrofit
import com.example.mvvm_hilt_project.retrofit.NetworkMapper
import com.example.mvvm_hilt_project.room.BlogDao
import com.example.mvvm_hilt_project.room.CacheMapper
import com.example.mvvm_hilt_project.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val blogDao:BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow{
        emit(DataState.Loading)
        delay(100)
        try {

            val networkBlogs=blogRetrofit.get()
            val blogs=networkMapper.mapFromEntityList(networkBlogs)
            for(blog in blogs){
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))

        }
        catch (e:Exception){

            emit(DataState.Error(e))

        }
    }
}