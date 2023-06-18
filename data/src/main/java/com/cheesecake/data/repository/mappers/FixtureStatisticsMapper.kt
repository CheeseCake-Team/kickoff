package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.FixtureStatisticsDTO
import com.cheesecake.domain.entity.FixtureStatistics

fun List<FixtureStatisticsDTO>.toEntity(): List<FixtureStatistics> {
    if (this.isEmpty())
        throw Exception()
    return this[0].statistics.indices.map { i ->
        val type = this[0].statistics[i].type
        val homeTeamValue = this[0].statistics[i].value.percentageToInt()
        val awayTeamValue = this[1].statistics[i].value.percentageToInt()

        FixtureStatistics(type, homeTeamValue, awayTeamValue)
    }
}

fun String?.percentageToInt(): Int = this?.replace("%", "")?.toIntOrNull() ?: 0

