package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = hiltViewModel<HomeViewModel>()

    when (viewModel.homeUiState) {
        is HomeViewModel.HomeUiState.Loading -> LoadingScreen()
        is HomeViewModel.HomeUiState.Success -> UsersList(
            ((viewModel.homeUiState as HomeViewModel.HomeUiState.Success).users),
            navController
        )

        is HomeViewModel.HomeUiState.Error -> ErrorScreen()
    }
}