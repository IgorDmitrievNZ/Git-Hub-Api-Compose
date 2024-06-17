package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun HomeScreen(homeUiState: HomeUiState, navController: NavController) {

    when (homeUiState) {
        is HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Success -> UsersList(homeUiState.users, navController)
        is HomeUiState.Error -> ErrorScreen()
    }
}