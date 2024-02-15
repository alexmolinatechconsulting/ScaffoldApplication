package com.example.scaffoldapplication.service

import com.example.scaffoldapplication.BuildConfig
import com.example.scaffoldapplication.data.MovieDataList
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {
    @GET(BuildConfig.ENDPOINT_MOVIE)
    suspend fun getMovies(
        @Header("Authorization") token : String = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjJmY2VjNjNmMTNkY2RmNGJmYTRhMmI3ZTgzNTY4ZCIsInN1YiI6IjY1YzE1OTZjOTAyMDEyMDE2MmNjZjVlOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.yv9UOqZVlrGoD6yrnBRf1eZZoujWCu2JkCTpg8EKF4w",
        @Query("language") language : String = "en-US"
    ) : MovieDataList
}