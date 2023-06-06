package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class ScoreStatusString(
    @SerializedName("home")
    val home: String,
    @SerializedName("away")
    val away: String
)
