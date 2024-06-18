package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun UserDetailsScreen() {
    val detailsViewModel = viewModel<UserDetailsViewModel>()
    when (detailsViewModel.detailUiState) {
        is DetailUiState.Loading -> LoadingScreen()
        is DetailUiState.Success -> UserDetailsContent((detailsViewModel.detailUiState as DetailUiState.Success).userDetail)
        is DetailUiState.Error -> ErrorScreen()
    }
}