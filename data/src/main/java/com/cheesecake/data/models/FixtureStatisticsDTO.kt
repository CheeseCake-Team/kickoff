package com.cheesecake.data.models


import com.cheesecake.data.models.base.Team
import com.google.gson.annotations.SerializedName

data class FixtureStatisticsDTO(
    @SerializedName("team")
    val team: Team,
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