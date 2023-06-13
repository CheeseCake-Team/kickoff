package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class TeamDataDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String
)
