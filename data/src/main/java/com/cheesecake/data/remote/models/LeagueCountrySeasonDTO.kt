package com.cheesecake.data.remote.models

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
    val season: String
)
