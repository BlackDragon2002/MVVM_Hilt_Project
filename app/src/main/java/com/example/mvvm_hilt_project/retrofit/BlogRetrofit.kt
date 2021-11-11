package com.example.mvvm_hilt_project.retrofit

import retrofit2.http.GET

interface BlogRetrofit {
    @GET("blogs")
    suspend fun get() : List<BlogNetworkEntity>
}