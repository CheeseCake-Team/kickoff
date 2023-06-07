package com.cheesecake.data.remote.response


import com.cheesecake.data.remote.models.TeamDTO
import com.google.gson.annotations.SerializedName

data class FixtureStatisticsResponse(
    @SerializedName("team")
    val team: com.cheesecake.data.remote.models.TeamDTO,
    @SerializedName("statistics")
    val statistics: List<com.cheesecake.data.remote.response.FixtureStatisticsResponse.Statistic>
) {
    data class Statistic(
        @SerializedName("type")
        val type: String,
        @SerializedName("value")
        val value: Int
    )
}