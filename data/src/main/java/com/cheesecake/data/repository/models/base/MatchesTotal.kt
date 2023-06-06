package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class MatchesTotal(
    @SerializedName("home") val home: Int,
    @SerializedName("away") val away: Int,
    @SerializedName("total") val total: Int
)