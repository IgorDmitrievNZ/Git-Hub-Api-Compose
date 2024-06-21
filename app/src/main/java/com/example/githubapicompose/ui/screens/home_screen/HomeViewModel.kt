package com.example.githubapicompose.ui.screens.home_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapicompose.model.search_dto.SearchDTO
import com.example.githubapicompose.model.users_dto.UserDTO
import com.example.githubapicompose.network.ApiClient
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel : ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set
    var searchUiState: SearchUiState by mutableStateOf(SearchUiState.Loading)
        private set

    var searchResult by mutableStateOf("igor")

    init {
        getUsers()
        getSearch(searchResult)
    }

    private fun getUsers() {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading
            homeUiState = try {
                val listResult = ApiClient.retrofitService.getUsers()
                Log.d("My list:", listResult.toString())
                HomeUiState.Success(listResult)
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }

    private fun getSearch(search: String) {
        viewModelScope.launch {
            searchUiState = SearchUiState.Loading
            searchUiState = try {
                val listResult = ApiClient.retrofitService.getSearchResult(search)
                Log.d("My list2:", listResult.toString())
                SearchUiState.Success(listResult)
            } catch (e: IOException) {
                SearchUiState.Error
            } catch (e: HttpException) {
                SearchUiState.Error
            }
        }
    }

    /**
     * UI state for the Home screen
     */
    sealed interface HomeUiState {
        data class Success(val users: List<UserDTO>) : HomeUiState
        data object Error : HomeUiState
        data object Loading : HomeUiState
    }

    sealed interface SearchUiState {
        data class Success(val searchResult: SearchDTO) : SearchUiState
        data object Error : SearchUiState
        data object Loading : SearchUiState
    }
}