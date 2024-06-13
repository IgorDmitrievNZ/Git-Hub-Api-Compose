package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.githubapicompose.model.UserDTO

@Composable
fun UsersList(users: List<UserDTO>) {
    LazyColumn {
        items(users) { item ->
            UserCard(user = item, modifier = Modifier)
        }
    }
}