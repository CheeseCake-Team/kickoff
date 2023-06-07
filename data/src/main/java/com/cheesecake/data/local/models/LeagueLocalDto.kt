package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cheesecake.domain.entity.LeagueEntity

@Entity("league_table")
data class LeagueLocalDto(
    @PrimaryKey val leagueId: Int,
    val leagueName: String,
    val leagueSeason: String,
    val leagueLogoUrl: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val isFavourite: Boolean
)

fun LeagueLocalDto.mapToDomain(): LeagueEntity {
    return LeagueEntity(
        leagueId = leagueId,
        leagueName = leagueName,
        leagueSeason = leagueSeason,
        leagueLogo = leagueLogoUrl,
        seasonStartYear = seasonStartYear,
        seasonEndYear = seasonEndYear,
        isFavourite = isFavourite
    )
}

fun List<LeagueLocalDto>.mapToDomain(): List<LeagueEntity> {
    return this.map { it.mapToDomain() }
}

fun LeagueEntity.toLocal(): LeagueLocalDto {
    return LeagueLocalDto(
        leagueId = leagueId,
        leagueName = leagueName,
        leagueSeason = leagueSeason,
        leagueLogoUrl = leagueLogo,
        seasonStartYear = seasonStartYear,
        seasonEndYear = seasonEndYear,
        isFavourite = isFavourite
    )
}