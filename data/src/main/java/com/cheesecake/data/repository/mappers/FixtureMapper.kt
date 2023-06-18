package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.FixtureDTO
import com.cheesecake.data.remote.utils.FixtureStatus
import com.cheesecake.domain.entity.Fixture
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@JvmName("fixtureDTOToFixture")
fun FixtureDTO.toEntity(): Fixture {
    return Fixture(
        id = this.fixtureDataDTO.id,
        matchId = "${this.teams.home.id}-${this.teams.away.id}",
        leagueName = this.league.name,
        homeTeamName = this.teams.home.name,
        homeTeamLogoUrl = this.teams.home.logo,
        homeTeamGoals = this.goals.home.toString(),
        awayTeamName = this.teams.away.name,
        awayTeamLogoUrl = this.teams.away.logo,
        awayTeamGoals = this.goals.away.toString(),
        matchTime = this.fixtureDataDTO.date?.toString(),
        matchDate = this.fixtureDataDTO.date ?: Date(),
        isFinished = this.fixtureDataDTO.status.short == FixtureStatus.MatchFinished.toString(),
        leagueSeason = this.league.season
    )
}


@JvmName("fixtureDTOsToFixtures")
fun List<FixtureDTO>.toEntity(): List<Fixture> {
    return this.map { it.toEntity() }
}


private fun formatDate(dateString: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val outputFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM", Locale.ENGLISH)
    val date = LocalDate.parse(dateString, inputFormatter)
    return date.format(outputFormatter)
}