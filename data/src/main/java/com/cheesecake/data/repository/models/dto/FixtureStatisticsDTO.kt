package com.cheesecake.data.repository.models.dto


import com.cheesecake.data.repository.models.base.Team
import com.google.gson.annotations.SerializedName

data class FixtureStatisticsDTO(
    @SerializedName("team")
    val team: com.cheesecake.data.repository.models.base.Team,
    @SerializedName("statistics")
    val statistics: List<com.cheesecake.data.repository.models.dto.FixtureStatisticsDTO.Statistic>
) {
    data class Statistic(
        @SerializedName("type")
        val type: String,
        @SerializedName("value")
        val value: Int
    )
}