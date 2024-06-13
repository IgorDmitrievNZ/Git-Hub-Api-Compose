package com.example.githubapicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubapicompose.ui.screens.home_screen.HomeScreen
import com.example.githubapicompose.ui.screens.home_screen.HomeViewModel
import com.example.githubapicompose.ui.theme.GitHubApiComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubApiComposeTheme {
                val homeViewModel: HomeViewModel = viewModel()
                HomeScreen(
                    homeUiState = homeViewModel.homeUiState,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}