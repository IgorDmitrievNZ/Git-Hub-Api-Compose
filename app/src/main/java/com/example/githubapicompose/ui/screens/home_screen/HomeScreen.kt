package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun HomeScreen(homeUiState: HomeUiState, modifier: Modifier) {

    when (homeUiState) {
        is HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Success -> UsersList(homeUiState.users)
        is HomeUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}