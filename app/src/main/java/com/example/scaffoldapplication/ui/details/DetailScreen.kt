package com.example.scaffoldapplication.ui.details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scaffoldapplication.ui.MovieListViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(vm : MovieListViewModel, movieId : Int, nav : NavHostController) {
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
                        onClick = { nav.navigate(route="MovieList") }
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
        }
    ){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Text(
                modifier = Modifier.padding(8.dp),
                text = vm.movies[movieId].overview?.trimIndent() ?: ""
            )
        }
    }
}