package com.cheesecake.domain.entity

data class FixtureStatistics(
    val type: String,
    val homeTeamValue: Int,
    val awayTeamValue: Int,
    ) {
    val homeTeamPercentage = if (getTotalValue() != 0) homeTeamValue * 100 / getTotalValue() else 0
    val awayTeamPercentage = if (getTotalValue() != 0) awayTeamValue * 100 / getTotalValue() else 0


    private fun getTotalValue(): Int {
        return homeTeamValue + awayTeamValue
    }

}