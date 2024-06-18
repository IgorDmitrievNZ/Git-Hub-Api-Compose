package com.example.githubapicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.githubapicompose.ui.theme.GitHubApiComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubApiComposeTheme {
                Scaffold(content = { paddingValues ->
                    Surface(modifier = Modifier.padding(paddingValues)) {
                        Navigation()
                    }
                })
            }
        }
    }
}