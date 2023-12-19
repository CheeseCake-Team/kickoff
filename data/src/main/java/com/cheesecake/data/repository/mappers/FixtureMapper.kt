package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.FixtureDTO
import com.cheesecake.domain.entity.Fixture
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@JvmName("fixtureDTOToFixture")
fun FixtureDTO.toEntity(): Fixture {
    return Fixture(
        id = this.fixtureDataDTO.id,
        competitionId = this.league.id,
        homeTeamID = this.teams.home.id,
        awayTeamID = this.teams.away.id,
        leagueName = this.league.name,
        homeTeamName = this.teams.home.name,
        homeTeamLogoUrl = this.teams.home.logo,
        homeTeamGoals = this.goals.home.toString(),
        awayTeamName = this.teams.away.name,
        awayTeamLogoUrl = this.teams.away.logo,
        awayTeamGoals = this.goals.away.toString(),
        matchDate = this.fixtureDataDTO.date,
        matchState = this.fixtureDataDTO.status.short,
        leagueSeason = this.league.season,
        leagueLogoUrl = this.league.logo
    )
}

@JvmName("fixtureDTOsToFixtures")
fun List<FixtureDTO>.toEntity(): List<Fixture> {
    return this.map { it.toEntity() }
}