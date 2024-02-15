package com.example.scaffoldapplication.network

import com.example.scaffoldapplication.BuildConfig
import com.example.scaffoldapplication.service.MovieApi
import com.example.scaffoldapplication.service.MovieApiImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val NetworkModule = module {
    single{ OkHttpClient() }
    single{
        Retrofit
            .Builder()
            .client(get())
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<MovieApi>{MovieApiImpl(get())}
}