package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class GoalsState(
    @SerializedName("total")
    val total: Int,
    @SerializedName("conceded")
    val conceded: Int,
    @SerializedName("assists")
    val assists: Int,
    @SerializedName("saves")
    val saves: Any
)
