package com.example.githubapicompose.ui.screens.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapicompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getUsers()
    }

    //Custom data model object
    data class UsersModel(
        val avatarUrl: String?,
        val login: String,
    )

    private fun getUsers() {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading
            homeUiState = try {
                val listResult: List<UsersModel> =
                    repository.getUsersFromServer().map {
                        UsersModel(
                            avatarUrl = it.avatarUrl,
                            login = it.login
                        )
                    }
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
        data class Success(val users: List<UsersModel>) : HomeUiState
        data object Error : HomeUiState
        data object Loading : HomeUiState
    }
}