package com.example.scaffoldapplication.service

import com.example.scaffoldapplication.data.MovieDataList
import retrofit2.Retrofit

class MovieApiImpl(private var retrofit : Retrofit) : MovieApi {
    override suspend fun getMovies(token: String, language: String) : MovieDataList {
        val service = retrofit.create(MovieApi::class.java)
        return service.getMovies()
    }
}