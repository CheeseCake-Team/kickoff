package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class MatchesTotalDTO(
    @SerializedName("home") val home: Int,
    @SerializedName("away") val away: Int,
    @SerializedName("total") val total: Int
)