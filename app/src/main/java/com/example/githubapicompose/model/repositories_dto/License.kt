package com.example.githubapicompose.model.repositories_dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
    val key: String?,
    val name: String?,
    @SerialName("node_id") val nodeId: String?,
    @SerialName("spdx_id") val spdxId: String?,
    val url: String?
)