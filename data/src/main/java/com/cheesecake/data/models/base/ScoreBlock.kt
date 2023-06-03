package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class ScoreBlock(
    @SerializedName("halftime")
    val halftime: ScoreStatus,
    @SerializedName("fulltime")
    val fulltime: ScoreStatus,
    @SerializedName("extratime")
    val extratime: ScoreStatus,
    @SerializedName("penalty")
    val penalty: ScoreStatus
)
