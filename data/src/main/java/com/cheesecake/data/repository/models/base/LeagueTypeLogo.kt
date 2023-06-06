package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class LeagueTypeLogo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("logo")
    val logo: String
)

