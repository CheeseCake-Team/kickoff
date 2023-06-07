package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class MatchesDTO(
    @SerializedName("home")
    val home: Int?,
    @SerializedName("away")
    val away: Int?
)
