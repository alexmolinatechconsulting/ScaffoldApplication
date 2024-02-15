package com.example.scaffoldapplication.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.scaffoldapplication.data.MovieData
import com.example.scaffoldapplication.ui.MovieListViewModel

@Composable
fun DetailScreen(viewModel : MovieListViewModel, movieId : Int) {
    val movie = viewModel.movies[movieId]
    Column {
        Text(
            text = movie.title!!
        )
    }
}