package com.example.scaffoldapplication.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.scaffoldapplication.data.MovieData
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.scaffoldapplication.BuildConfig
import com.example.scaffoldapplication.ui.MovieListViewModel


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageScreen(viewModel : MovieListViewModel, movieId : Int) {
    val movie = viewModel.movies[movieId]
    Column {
        GlideImage(
            model = "${BuildConfig.BASE_IMAGE_URL}${movie.poster_path}",
            contentDescription = "Movie Poster"
        )
    }
}