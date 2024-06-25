package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.githubapicompose.model.repositories_dto.RepoDTO
import com.example.githubapicompose.model.user_details_dto.UserDetailsDTO

@Composable
fun UserDetailsContent(detailsDto: UserDetailsDTO, reposDTO: List<RepoDTO>) {

    Column {
        Text(
            modifier = Modifier
                .padding(start = 10.dp, top = 50.dp, bottom = 10.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge,
            text = "Login: ${detailsDto.login}"
        )

        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.headlineLarge,
            text = "${detailsDto.name}"
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

        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge,
            text = "Repositories:"
        )

        LazyRow(
            modifier = Modifier
        ) {
            items(reposDTO) { item ->
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .background(Color.Cyan)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(10.dp),
                        text = "${item.name}"
                    )
                }
            }
        }
    }
}