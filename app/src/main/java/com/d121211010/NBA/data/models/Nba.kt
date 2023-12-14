package com.d121211010.NBA.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Nba(
    @SerialName(value = "abbreviation" )
    val abbreviation: String?,
    @SerialName(value = "city")
    val city: String?,
    @SerialName(value = "conference")
    val conference: String?,
    @SerialName(value = "division")
    val division: String?,
    @SerialName(value = "full_name")
    val full_name: String?,
    @SerialName(value = "id")
    val id: Int?,
    @SerialName(value = "name")
    val name: String?
): Parcelable