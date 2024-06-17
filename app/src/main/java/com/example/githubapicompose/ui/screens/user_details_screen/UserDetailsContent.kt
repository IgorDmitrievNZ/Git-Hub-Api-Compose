package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun UserDetailsContent() {
    Column {
        Text(text = "Login")
        Text(text = "Name")
        Text(text = "Location")
        AsyncImage(model = "", contentDescription = "")
        LazyRow {
            items(5) {
                Text(text = "repos")
            }
        }
    }
}