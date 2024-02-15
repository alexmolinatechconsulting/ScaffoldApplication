package com.example.scaffoldapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeapi.MovieListScreen
import com.example.scaffoldapplication.ui.MovieListViewModel
import org.koin.android.ext.android.get
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.scaffoldapplication.ui.details.MovieDetailScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = get<MovieListViewModel>()

        setContent {
                // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                var nav = rememberNavController()

                NavHost(navController = nav, startDestination = "MovieList"){
                    composable("MovieList"){
                        MovieListScreen(vm = viewModel, nav = nav)
                    }
                    composable(route = "Details/{movieId}",
                        arguments = listOf(
                            navArgument(name = "movieId") {
                                type = NavType.IntType
                            }
                        )
                    ){ movieId ->
                        MovieDetailScreen(viewModel, movieId.arguments?.getInt("movieId")!!, nav)
                    }
                }
            }
        }
    }
}