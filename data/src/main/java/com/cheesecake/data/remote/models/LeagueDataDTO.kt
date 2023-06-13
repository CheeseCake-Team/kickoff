package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class LeagueDataDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("logo")
    val logo: String
)

