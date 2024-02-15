package com.example.composeapi

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.material.TextButton
import androidx.compose.material3.Divider
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scaffoldapplication.ui.MovieListViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(vm : MovieListViewModel, nav : NavHostController) {

    LaunchedEffect(Unit, block = {
        vm.getMovies()
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("Movies")
                    }
                }
            )
        },
        content = {
            Column {
                LazyColumn(
                    modifier = Modifier.fillMaxHeight()
                ) {

                    val itemCount = vm.movies.size
                    items(itemCount) {
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                TextButton(
                                    onClick = {
                                        nav.navigate("Details/${it}")
                                    }
                                ) {
                                    Text(text=vm.movies[it].title ?: "")
                                }
                            }
                            Divider()
                        }
                    }
                }
            }
        }
    )
}