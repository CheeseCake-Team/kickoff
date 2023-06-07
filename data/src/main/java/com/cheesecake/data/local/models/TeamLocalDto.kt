package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cheesecake.domain.entity.TeamEntity

@Entity(tableName = "team_table")
data class TeamLocalDto(
    @PrimaryKey val teamId: Int,
    val leagueId: Int,
    val season: Int,
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String,
    val isFavourite: Boolean = false
)

fun TeamLocalDto.mapToDomain(): TeamEntity {
    return TeamEntity(
        teamId, teamName, founded, teamCountry, venueCapacity, venueName, imageUrl, isFavourite
    )
}

fun List<TeamLocalDto>.mapToDomain(): List<TeamEntity> {
    return this.map { it.mapToDomain() }
}

fun TeamEntity.toLocal(leagueId: Int, leagueSeason: Int): TeamLocalDto {
    return TeamLocalDto(
        teamId = this.teamId,
        leagueId = leagueId,
        season = leagueSeason,
        teamName = this.teamName,
        founded = this.founded,
        teamCountry = this.teamCountry,
        venueCapacity = this.venueCapacity,
        venueName = this.venueName,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite
    )
}

fun List<TeamEntity>.mapToLocal(leagueId: Int, leagueSeason: Int): List<TeamLocalDto> {
    return this.map { it.toLocal(leagueId, leagueSeason) }
}