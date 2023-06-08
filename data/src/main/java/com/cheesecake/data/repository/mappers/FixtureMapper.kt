package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.remote.utils.FixtureStatus
import com.cheesecake.domain.entity.FixtureEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


fun FixtureResponse.mapToDomain(): FixtureEntity {
    return FixtureEntity(
        homeTeamName = this.teams.home.name,
        homeTeamLogo = this.teams.home.logo,
        homeTeamGoals = this.goals.home.toString(),
        awayTeamName = this.teams.away.name,
        awayTeamLogo = this.teams.away.logo,
        awayTeamGoals = this.goals.away.toString(),
        matchTime = this.fixtureDTO.date.substring(11, 16),
        matchDate = formatDate(this.fixtureDTO.date.substring(0, 10)),
        isFinished = this.fixtureDTO.status.short == FixtureStatus.MatchFinished.toString()
    )
}

fun List<FixtureResponse>.mapToDomain(): List<FixtureEntity> {
    return this.map { it.mapToDomain() }
}


private fun formatDate(dateString: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val outputFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM", Locale.ENGLISH)
    val date = LocalDate.parse(dateString, inputFormatter)
    return date.format(outputFormatter)
}