package com.example.scaffoldapplication.ui.details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.scaffoldapplication.BuildConfig
import com.example.scaffoldapplication.ui.MovieListViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ImageScreen(vm : MovieListViewModel, movieId : Int, nav : NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = vm.movies[movieId].title ?: "Movie",
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { nav.navigate("MovieList")}
                    ){
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Button",
                        )
                    }
                },
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Details",
                        route = "Details/${movieId}"
                    ),
                    BottomNavItem(
                        name = "Image",
                        route = "Image/${movieId}"
                    )
                ),
                nav = nav,
                onItemClick = {
                    nav.navigate(it.route)
                },
                modifier = Modifier.background(Color.White)
            )
        },
        content = {
            Column {
                GlideImage(
                    model = "${BuildConfig.BASE_IMAGE_URL}${vm.movies[movieId].poster_path}",
                    contentDescription = "Movie Poster",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    )
}