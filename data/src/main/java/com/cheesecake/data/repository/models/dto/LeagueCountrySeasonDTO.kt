package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class LeagueCountrySeasonDTO(
    @SerializedName("country")
    val country: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("season")
    val season: Int
)
