package com.example.mvvm_hilt_project.di

import com.example.mvvm_hilt_project.retrofit.BlogRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder() : Gson=
        GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson):Retrofit.Builder =
        Retrofit.Builder()
        .baseUrl("https://open-api.xyz/placeholder/")
        .addConverterFactory(GsonConverterFactory.create(gson))

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder):BlogRetrofit=
        retrofit
        .build()
        .create(BlogRetrofit::class.java)

}