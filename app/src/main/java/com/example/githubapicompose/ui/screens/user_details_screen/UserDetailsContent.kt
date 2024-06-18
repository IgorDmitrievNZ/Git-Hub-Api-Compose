package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.githubapicompose.model.user_details_dto.UserDetailsDTO

@Composable
fun UserDetailsContent(detailsDto: UserDetailsDTO) {

    Column {
        Text(
            modifier = Modifier
                .padding(start = 10.dp, top = 100.dp, bottom = 10.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge,
            text = "Login: ${detailsDto.login}"
        )

        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.headlineLarge,
            text = "Name: ${detailsDto.name}"
        )

        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyLarge,
            text = "Location: ${detailsDto.location}"
        )

        AsyncImage(
            modifier = Modifier
                .padding(10.dp)
                .size(300.dp)
                .align(Alignment.CenterHorizontally),
            model = detailsDto.avatar_url, contentDescription = "avatar"
        )

        LazyRow(
            modifier = Modifier
        ) {
            items(15) { item ->
                Text(
                    modifier = Modifier
                        .padding(10.dp), text = "Repository" + (item + 1)
                )
            }
        }
    }
}