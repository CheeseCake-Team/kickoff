package com.cheesecake.data.repository.models.response


import com.cheesecake.data.repository.models.dto.TeamDTO
import com.google.gson.annotations.SerializedName

data class FixtureStatisticsResponse(
    @SerializedName("team")
    val team: TeamDTO,
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