package com.example.scaffoldapplication

import android.app.Application
import com.example.scaffoldapplication.network.NetworkModule
import com.example.scaffoldapplication.ui.MovieModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ScaffoldMovieApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@ScaffoldMovieApp)
            modules(listOf(NetworkModule, MovieModule))
        }
    }
}