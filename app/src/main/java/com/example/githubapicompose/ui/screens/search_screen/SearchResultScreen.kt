package com.example.githubapicompose.ui.screens.search_screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.githubapicompose.R
import com.example.githubapicompose.Screen
import com.example.githubapicompose.ui.screens.error_screen.ErrorScreen
import com.example.githubapicompose.ui.screens.loading_screen.LoadingScreen

@Composable
fun SearchResultScreen(searchUiState: SearchViewModel.SearchUiState, navController: NavController) {

    when (searchUiState) {
        is SearchViewModel.SearchUiState.Loading -> LoadingScreen()
        is SearchViewModel.SearchUiState.Success -> SearchList(searchUiState.searchDto, navController)
        is SearchViewModel.SearchUiState.Error -> ErrorScreen()
    }
}

@Composable
private fun SearchList(
    searchList: List<SearchViewModel.SearchModel>, navController: NavController) {
    LazyColumn {
        items(searchList) { item ->
            SearchCardContent(dto = item, navController)
        }
    }
}

@Composable
private fun SearchCardContent(dto: SearchViewModel.SearchModel, navController: NavController) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(5.dp)
            .clickable {
                Toast
                    .makeText(context, dto.login, Toast.LENGTH_SHORT)
                    .show()
                navController.navigate(Screen.DetailsScreenRoute.withArgs(dto.login))
            }

    )
    {
        //card content bellow
        Row {
            AsyncImage(
                model = dto.avatarUrl,
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight()
                    .padding(5.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = dto.login
                )
            }
        }
    }
}