package com.example.githubapicompose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubapicompose.ui.screens.home_screen.HomeScreen
import com.example.githubapicompose.ui.screens.home_screen.HomeViewModel
import com.example.githubapicompose.ui.screens.user_details_screen.UserDetailsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val homeViewModel: HomeViewModel = viewModel()

    //main screen route
    NavHost(navController = navController, startDestination = Screen.HomeScreenRoute.route) {
        composable(Screen.HomeScreenRoute.route) {
            HomeScreen(homeViewModel.homeUiState,navController = navController)
        }

        //route to user details
        composable(
            Screen.DetailsScreenRoute.route + "/{login}",
            arguments = listOf(
                navArgument("login") {
                    type = NavType.StringType
                    defaultValue = "User Login"
                    nullable = true
                }
            )
        ) {
            UserDetailsScreen()
        }

        //next route here
    }

}