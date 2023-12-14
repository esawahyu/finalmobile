package com.d121211010.NBA.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("current_page")
    val current_page: Int,
    @SerialName("results")
    val results: List<Nba>? = null,
    @SerialName("next_page")
    val next_page: Int? = null,
    @SerialName("per_page")
    val per_page: Int,
    @SerialName("total_count")
    val total_count: Int,
    @SerialName("total_pages")
    val total_pages: Int
)