@file:Suppress("PLUGIN_IS_NOT_ENABLED")

package com.d121211010.NBA.data.response

import com.d121211010.NBA.data.models.Meta
import com.d121211010.NBA.data.models.Nba
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetNbaResponse(
    @SerialName(value = "data")
    val `data`: List<Nba>,
    @SerialName(value = "meta")
    val meta: Meta
)