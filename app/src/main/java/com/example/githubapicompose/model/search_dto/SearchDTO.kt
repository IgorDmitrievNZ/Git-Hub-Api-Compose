package com.example.githubapicompose.model.search_dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchDTO(
    val incomplete_results: Boolean?,
    val items: List<Item>?,
    val total_count: Int?
)