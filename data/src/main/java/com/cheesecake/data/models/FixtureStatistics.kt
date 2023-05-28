package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class FixtureStatistics(
    @SerializedName("team")
    val team: Team,
    @SerializedName("statistics")
    val statistics: List<Statistic>
) {
    data class Team(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("logo")
        val logo: String
    )

    data class Statistic(
        @SerializedName("type")
        val type: String,
        @SerializedName("value")
        val value: Int
    )
}