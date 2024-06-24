package com.example.githubapicompose.ui.screens.search_screen

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.githubapicompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(navController: NavController) {
    val viewModel = viewModel<SearchViewModel>()
    val context = LocalContext.current
    var text by remember { mutableStateOf(viewModel.searchText) } // Query for SearchBar
    var isActive by remember { mutableStateOf(false) } // Active state for SearchBar

    Column {

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            query = text,
            onQueryChange = { text = it },
            onSearch = { isActive = true },
            active = isActive,
            onActiveChange = { isActive = it },
            placeholder = { Text(text = stringResource(id = R.string.enter_user_login)) },
            windowInsets = WindowInsets(top = 0.dp),
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .clickable {
                            if (text.isNotEmpty()) {
                                viewModel.searchText = text
                                viewModel.getSearch(viewModel.searchText)
                                isActive = false
                            } else {
                                Toast.makeText(
                                    context,
                                    R.string.please_enter_text_in_field,
                                    Toast.LENGTH_SHORT
                                ).show()
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
                                viewModel.searchText = ""
                            } else {
                                isActive = false
                            }
                        },
                        imageVector = Icons.Default.Close, contentDescription = null
                    )
                }
            },
        ) {
            UserListItem(enteredText = text)
        }
        if (viewModel.searchText.isNotEmpty()) {
            SearchScreen(navController)//result
        }
    }

}

@Composable
fun UserListItem(enteredText: String) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = enteredText)
    }
}