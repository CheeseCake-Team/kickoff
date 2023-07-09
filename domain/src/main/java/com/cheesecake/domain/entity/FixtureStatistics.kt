package com.cheesecake.domain.entity

data class FixtureStatistics(
    val type: String,
    val statisticsType: StatisticsType,
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

enum class StatisticsType {
    Fouls, YELLOW_CARD, RED_CARD, OFF_SIDES, ACCURATE_PASSES, ACCURATE_PASSES_PERCENTAGE, EXPECTED_GOALS, UNKNOWN;

    override fun toString(): String {
        return when (this) {
            Fouls -> "Fouls"
            YELLOW_CARD -> "Yellow Cards"
            RED_CARD -> "Red Cards"
            OFF_SIDES -> "Offsides"
            ACCURATE_PASSES -> "Passes accurate"
            ACCURATE_PASSES_PERCENTAGE -> "Passes %"
            EXPECTED_GOALS -> "expected_goals"
            UNKNOWN -> "Unknown"
        }
    }

}