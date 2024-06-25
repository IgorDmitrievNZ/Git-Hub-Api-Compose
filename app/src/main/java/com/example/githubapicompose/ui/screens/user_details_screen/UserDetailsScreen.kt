package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun UserDetailsScreen() {
    val detailsViewModel = viewModel<UserDetailsViewModel>()

    when (detailsViewModel.detailUiState) {

        is UserDetailsViewModel.DetailUiState.Loading -> LoadingScreen()

        is UserDetailsViewModel.DetailUiState.Success -> UserDetailsContent(
            (detailsViewModel.detailUiState as UserDetailsViewModel.DetailUiState.Success).userDetail,
            (detailsViewModel.detailUiState as UserDetailsViewModel.DetailUiState.Success).userRepos
        )

        is UserDetailsViewModel.DetailUiState.Error -> ErrorScreen()
    }
}