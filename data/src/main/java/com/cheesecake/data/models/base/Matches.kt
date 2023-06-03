package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class Matches(
    @SerializedName("home") val home: Int,
    @SerializedName("away") val away: Int,
    @SerializedName("total") val total: Int
)