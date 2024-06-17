package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.githubapicompose.model.UserDTO

@Composable
fun UsersList(users: List<UserDTO>, navController: NavController) {
    LazyColumn {
        items(users) { item ->
            UserCard(user = item, navController)
        }
    }
}