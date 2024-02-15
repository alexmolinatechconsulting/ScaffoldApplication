package com.example.scaffoldapplication.network

import com.example.scaffoldapplication.BuildConfig
import com.example.scaffoldapplication.service.MovieApi
import com.example.scaffoldapplication.service.MovieApiImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {
    single{
        OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
    }
    single{
        Retrofit
            .Builder()
            .client(get())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<MovieApi>{MovieApiImpl(get())}
}