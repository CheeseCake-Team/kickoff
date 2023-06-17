package com.cheesecake.domain.entity

data class FixtureStatistics(
    val type: String,
    val homeTeamValue: Int,
    val awayTeamValue: Int,
)

fun FixtureStatistics.getHomeTeamPercentage() =
    if (getTotalValue() != 0) homeTeamValue * 100 / getTotalValue() else 0

fun FixtureStatistics.getAwayTeamPercentage() =
    if (getTotalValue() != 0) awayTeamValue * 100 / getTotalValue() else 0

private fun FixtureStatistics.getTotalValue(): Int {
    return homeTeamValue + awayTeamValue
}