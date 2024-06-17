package com.example.githubapicompose

sealed class Screen(val route: String) {
    data object HomeScreenRoute : Screen("home_screen")
    data object DetailsScreenRoute : Screen("user_details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}