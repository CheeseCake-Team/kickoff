package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class ScoreStatusStringDTO(
    @SerializedName("home")
    val home: String,
    @SerializedName("away")
    val away: String
)
