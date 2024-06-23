package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.githubapicompose.Screen
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun HomeScreen(navController: NavController) {

    val homeViewModel = viewModel<HomeViewModel>()

    Column {

        Icon(
            modifier = Modifier
                .padding(10.dp)
                .size(40.dp)
                .clickable { navController.navigate(Screen.SearchScreenRoute.route) },
            imageVector = Icons.Default.Search,
            contentDescription = null
        )

        when (homeViewModel.homeUiState) {
            is HomeViewModel.HomeUiState.Loading -> LoadingScreen()
            is HomeViewModel.HomeUiState.Success -> UsersList(
                (homeViewModel.homeUiState as HomeViewModel.HomeUiState.Success).users,
                navController
            )

            is HomeViewModel.HomeUiState.Error -> ErrorScreen()
        }
    }
}