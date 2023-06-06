package com.cheesecake.data.repository.models.dto


import com.google.gson.annotations.SerializedName

data class TrophyDTO(
    @SerializedName("country")
    val country: String,
    @SerializedName("league")
    val league: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("season")
    val season: String
)