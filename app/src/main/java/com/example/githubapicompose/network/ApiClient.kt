package com.example.githubapicompose.network

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object ApiClient {
    val retrofitService: GitHubApiService by lazy {
        NetworkDataSource.retrofit.create(GitHubApiService::class.java)
    }
}