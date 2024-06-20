package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun HomeScreen(navController: NavController) {

    val homeViewModel = viewModel<HomeViewModel>()

    Column {
        SearchView(navController)

        when (homeViewModel.homeUiState) {
            is HomeUiState.Loading -> LoadingScreen()
            is HomeUiState.Success -> UsersList(
                (homeViewModel.homeUiState as HomeUiState.Success).users,
                navController
            )

            is HomeUiState.Error -> ErrorScreen()
        }
    }
}