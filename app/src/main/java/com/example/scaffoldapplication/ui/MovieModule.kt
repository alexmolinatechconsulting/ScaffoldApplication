package com.example.scaffoldapplication.ui

import org.koin.dsl.module

val MovieModule = module {
    factory { MovieListViewModel(get()) }
}
