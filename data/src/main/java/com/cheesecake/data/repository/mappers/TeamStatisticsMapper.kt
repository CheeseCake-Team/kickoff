package com.cheesecake.data.repository.mappers

import com.cheesecake.data.repository.models.response.TeamStatisticsResponse
import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.entity.TeamStats

fun TeamStatisticsResponse.toEntity(): TeamStatisticsEntity =
    TeamStatisticsEntity(
        home = TeamStats(
            played = this.fixtures.played.home,
            wins = this.fixtures.wins.home,
            draws = this.fixtures.draws.home,
            loses = this.fixtures.loses.home,
            cleanSheet = this.fixtures.played.home,
            failedToScore = this.cleanSheet.home,
            goalsFor = this.goals.goalsFor.total.home,
            goalsAgainst = this.goals.goalsAgainst.total.home,
        ),
        away = TeamStats(
            played = this.fixtures.played.away,
            wins = this.fixtures.wins.away,
            draws = this.fixtures.draws.away,
            loses = this.fixtures.loses.away,
            cleanSheet = this.fixtures.played.away,
            failedToScore = this.cleanSheet.away,
            goalsFor = this.goals.goalsFor.total.away,
            goalsAgainst = this.goals.goalsAgainst.total.away,
        ),
        total = TeamStats(
            played = this.fixtures.played.total,
            wins = this.fixtures.wins.total,
            draws = this.fixtures.draws.total,
            loses = this.fixtures.loses.total,
            cleanSheet = this.fixtures.played.total,
            failedToScore = this.cleanSheet.total,
            goalsFor = this.goals.goalsFor.total.total,
            goalsAgainst = this.goals.goalsAgainst.total.total,
        )
    )