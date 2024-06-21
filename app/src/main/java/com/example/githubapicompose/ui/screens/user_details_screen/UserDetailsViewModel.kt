package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapicompose.model.user_details_dto.UserDetailsDTO
import com.example.githubapicompose.network.ApiClient
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UserDetailsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set
    private val loginUser: String = checkNotNull(savedStateHandle["login"])

    init {
        getDetails(loginUser)
    }

    private fun getDetails(login: String) {
        viewModelScope.launch {
            detailUiState = DetailUiState.Loading
            detailUiState = try {
                val listResult = ApiClient.retrofitService.getUserDetails(login)
                DetailUiState.Success(listResult)
            } catch (e: IOException) {
                DetailUiState.Error
            } catch (e: HttpException) {
                DetailUiState.Error
            }
        }
    }
}

sealed interface DetailUiState {
    data class Success(val userDetail: UserDetailsDTO) : DetailUiState
    data object Error : DetailUiState
    data object Loading : DetailUiState
}