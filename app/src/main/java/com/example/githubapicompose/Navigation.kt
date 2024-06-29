package com.example.githubapicompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.githubapicompose.ui.screens.home_screen.HomeScreen
import com.example.githubapicompose.ui.screens.search_screen.SearchScreen
import com.example.githubapicompose.ui.screens.user_details_screen.UserDetailsScreen

@Composable
fun Navigation(navController: NavHostController) {

    //main screen route
    NavHost(navController = navController, startDestination = Screen.HomeScreenRoute.route) {
        composable(Screen.HomeScreenRoute.route) {
            HomeScreen(navController = navController)
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
        //route to search view screen
        composable(
            Screen.SearchScreenRoute.route
        ) {
            SearchScreen(navController)
        }

        //next route here
    }

}