package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapicompose.model.users_dto.UserDTO
import com.example.githubapicompose.network.ApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading
            homeUiState = try {
                val listResult = ApiClient.retrofitService.getUsers()
                HomeUiState.Success(listResult)
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
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
}