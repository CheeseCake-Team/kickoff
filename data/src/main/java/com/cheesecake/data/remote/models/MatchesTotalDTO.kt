package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class MatchesTotalDTO(
    @SerializedName("home") val home: Float,
    @SerializedName("away") val away: Float,
    @SerializedName("total") val total: Float
)