package com.example.scaffoldapplication.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scaffoldapplication.data.MovieData
import com.example.scaffoldapplication.service.MovieApi
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(private var api : MovieApi): ViewModel() {

    private var _movies = mutableStateListOf<MovieData>()
    val movies: List<MovieData> = _movies

    fun getMovies() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val results = api.getMovies().results ?: emptyList()

            _movies.clear()
            _movies.addAll(results)
        }
    }
}