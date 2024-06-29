package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun UserDetailsScreen() {

    val viewModel = hiltViewModel<UserDetailsViewModel>()

    when (viewModel.detailUiState) {

        is UserDetailsViewModel.DetailUiState.Loading -> LoadingScreen()

        is UserDetailsViewModel.DetailUiState.Success -> UserDetailsContent(
            (viewModel.detailUiState as UserDetailsViewModel.DetailUiState.Success).userDetail,
            (viewModel.detailUiState as UserDetailsViewModel.DetailUiState.Success).userRepos
        )

        is UserDetailsViewModel.DetailUiState.Error -> ErrorScreen()
    }
}