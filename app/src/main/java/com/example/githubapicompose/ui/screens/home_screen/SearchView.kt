package com.example.githubapicompose.ui.screens.home_screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.githubapicompose.R
import com.example.githubapicompose.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(navController: NavController) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") } // Query for SearchBar
    var isActive by remember { mutableStateOf(false) } // Active state for SearchBar

    SearchBar(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        query = text,
        onQueryChange = { text = it },
        onSearch = { isActive = false },
        active = isActive,
        onActiveChange = { isActive = it },
        placeholder = { Text(text = stringResource(id = R.string.enter_user_login)) },
        windowInsets = WindowInsets(top = 0.dp),
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .clickable {
                        if (text.isNotEmpty()) {
                            navController.navigate(Screen.DetailsScreenRoute.withArgs(text))
                        }else{
                            Toast.makeText(context, "Please enter user name or login", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }, imageVector = Icons.Default.Search, contentDescription = null
            )
        },

        trailingIcon = {
            if (isActive) {
                Icon(
                    modifier = Modifier.clickable {
                        if (text.isNotEmpty()) {
                            text = ""
                        } else {
                            isActive = false
                        }
                    },
                    imageVector = Icons.Default.Close, contentDescription = null
                )
            }
        }
    ) {
        UserListItem(userLogin = text)
    }
}

@Composable
fun UserListItem(userLogin: String) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = userLogin)
    }
}