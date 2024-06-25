package com.example.githubapicompose.model.search_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchDTO(
    @SerialName("incomplete_results") val incompleteResults: Boolean?,
    val items: List<Item>,
    @SerialName("total_count") val totalCount: Int?
)