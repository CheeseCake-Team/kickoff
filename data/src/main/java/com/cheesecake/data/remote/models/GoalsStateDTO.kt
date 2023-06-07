package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class GoalsStateDTO(
    @SerializedName("total")
    val total: Int?,
    @SerializedName("conceded")
    val conceded: Int?,
    @SerializedName("assists")
    val assists: Int?,
    @SerializedName("saves")
    val saves: Int?
)
