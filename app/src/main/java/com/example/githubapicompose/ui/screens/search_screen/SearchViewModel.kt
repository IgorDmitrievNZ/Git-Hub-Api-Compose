package com.example.githubapicompose.ui.screens.search_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapicompose.model.search_dto.SearchDTO
import com.example.githubapicompose.network.ApiClient
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class SearchViewModel() : ViewModel() {
    var searchUiState: SearchUiState by mutableStateOf(SearchUiState.Loading)
        private set
    var searchText by mutableStateOf("igor")

    init {
        getSearch(searchText)
    }

    private fun getSearch(search: String) {
        viewModelScope.launch {
            searchUiState = SearchUiState.Loading
            searchUiState = try {
                val listResult = ApiClient.retrofitService.getSearchResult(search)
                Log.d("My list:", listResult.toString())
                SearchUiState.Success(listResult)
            } catch (e: IOException) {
                SearchUiState.Error
            } catch (e: HttpException) {
                SearchUiState.Error
            }
        }
    }

    sealed interface SearchUiState {
        data class Success(val searchDto: SearchDTO) : SearchUiState
        data object Error : SearchUiState
        data object Loading : SearchUiState
    }

}