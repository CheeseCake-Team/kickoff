package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class ScoreStatusStringDTO(
    @SerializedName("home")
    val home: String,
    @SerializedName("away")
    val away: String
)
