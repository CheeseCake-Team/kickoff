package com.cheesecake.data.remote.models


import com.google.gson.annotations.SerializedName

data class FixtureStatisticsDTO(
    @SerializedName("team")
    val team: TeamDataDTO,
    @SerializedName("statistics")
    val statistics: List<Statistic>
) {
    data class Statistic(
        @SerializedName("type")
        val type: String,
        @SerializedName("value")
        val value: Int
    )
}