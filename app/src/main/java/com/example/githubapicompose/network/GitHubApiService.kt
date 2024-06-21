package com.example.githubapicompose.network

import com.example.githubapicompose.model.search_dto.SearchDTO
import com.example.githubapicompose.model.user_details_dto.UserDetailsDTO
import com.example.githubapicompose.model.users_dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit service object for creating api calls
 */
interface GitHubApiService {
    @GET("users")
    suspend fun getUsers(): List<UserDTO>

    @GET("users/{userLogin}")
    suspend fun getUserDetails(
        @Path("userLogin") userLogin: String
    ): UserDetailsDTO

    @GET("search/users")
    suspend fun getSearchResult(
        @Query("q") q: String
    ): SearchDTO

}