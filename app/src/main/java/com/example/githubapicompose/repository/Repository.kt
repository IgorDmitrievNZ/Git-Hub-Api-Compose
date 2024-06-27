package com.example.githubapicompose.repository

import com.example.githubapicompose.model.repositories_dto.RepoDTO
import com.example.githubapicompose.model.search_dto.SearchDTO
import com.example.githubapicompose.model.user_details_dto.UserDetailsDTO
import com.example.githubapicompose.model.users_dto.UserDTO
import com.example.githubapicompose.network.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {
    suspend fun getUsersFromServer(): List<UserDTO> {
        return ApiClient.retrofitService.getUsers()
    }

    suspend fun getUserDetailsFromServer(login: String): UserDetailsDTO {
        return ApiClient.retrofitService.getUserDetails(login)
    }

    suspend fun getSearchResultFromServer(login: String): SearchDTO {
        return ApiClient.retrofitService.getSearchResult(login)
    }

    suspend fun getReposFromServer(userLogin: String): List<RepoDTO> {
        return ApiClient.retrofitService.getRepos(userLogin)
    }

}