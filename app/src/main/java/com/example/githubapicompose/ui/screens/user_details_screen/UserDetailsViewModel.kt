package com.example.githubapicompose.ui.screens.user_details_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapicompose.model.user_details_dto.UserDetailsDTO
import com.example.githubapicompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {
    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set
    private val loginUser: String = checkNotNull(savedStateHandle["login"])

    init {
        getDetails(loginUser)
    }

    data class UserDetailsModel(
        val avatarUrl: String?,
        val location: String?,
        val login: String,
        val name: String?,
    )

    data class RepoModel(
        val name: String?
    )

    private fun getDetails(login: String) {
        viewModelScope.launch {
            detailUiState = DetailUiState.Loading
            detailUiState = try {
                val detailsResult: UserDetailsDTO = repository.getUserDetailsFromServer(login)
                val details = UserDetailsModel(
                    avatarUrl = detailsResult.avatarUrl,
                    location = detailsResult.location,
                    login = detailsResult.login,
                    name = detailsResult.name
                )
                val reposResult: List<RepoModel> = repository.getReposFromServer(login).map {
                    RepoModel(
                        name = it.name
                    )
                }
                DetailUiState.Success(details, reposResult)
            } catch (e: IOException) {
                DetailUiState.Error
            } catch (e: HttpException) {
                DetailUiState.Error
            }
        }
    }

    sealed interface DetailUiState {
        data class Success(val userDetail: UserDetailsModel, val userRepos: List<RepoModel>) :
            DetailUiState

        data object Error : DetailUiState
        data object Loading : DetailUiState
    }
}