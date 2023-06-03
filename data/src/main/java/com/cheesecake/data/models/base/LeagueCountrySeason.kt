package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class LeagueCountrySeason(
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
