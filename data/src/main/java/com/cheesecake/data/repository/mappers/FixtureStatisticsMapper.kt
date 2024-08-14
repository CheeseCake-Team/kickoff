package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.FixtureStatisticsDTO
import com.cheesecake.domain.entity.FixtureStatistics
import com.cheesecake.domain.entity.StatisticsType

@JvmName("FixtureStatisticsDTOToFixtureStatistics")
fun List<FixtureStatisticsDTO>.toEntity(): List<FixtureStatistics> {
    if (this.isEmpty())
        return emptyList()
    return this.first().statistics.indices.map { i ->
        val type = this.first().statistics[i].type
        val statisticsType = toStatisticsType(type)
        val homeTeamValue = this.first().statistics[i].value.percentageToInt()
        val awayTeamValue = this.first().statistics[i].value.percentageToInt()

        FixtureStatistics(type, statisticsType, homeTeamValue, awayTeamValue)
    }
}

fun String?.percentageToInt(): Int = this?.replace("%", "")?.toIntOrNull() ?: 0

fun toStatisticsType(type: String): StatisticsType {
    return when (type) {
        "Fouls" -> StatisticsType.Fouls
        "Yellow Cards" -> StatisticsType.YELLOW_CARD
        "Red Cards" -> StatisticsType.RED_CARD
        "Offsides" -> StatisticsType.OFF_SIDES
        "Passes accurate" -> StatisticsType.ACCURATE_PASSES
        "Passes %" -> StatisticsType.ACCURATE_PASSES_PERCENTAGE
        "expected_goals" -> StatisticsType.EXPECTED_GOALS
        else -> StatisticsType.UNKNOWN
    }
}