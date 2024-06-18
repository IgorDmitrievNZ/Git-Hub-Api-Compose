package com.example.githubapicompose.network

import com.example.githubapicompose.model.user_details_dto.UserDetailsDTO
import com.example.githubapicompose.model.users_dto.UserDTO
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.github.com/"

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

/**
 * Retrofit service object for creating api calls
 */
interface UsersApiService {
    @GET("users")
    suspend fun getUsers(): List<UserDTO>
}

interface UserDetailsApiService {
    @GET("users/{userLogin}")
    suspend fun getUserDetails(@Path("userLogin") userLogin: String): UserDetailsDTO
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object DetailsApi {
    val retrofitService: UserDetailsApiService by lazy {
        retrofit.create(UserDetailsApiService::class.java)
    }
}

object UsersApi {
    val retrofitService: UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java)
    }
}