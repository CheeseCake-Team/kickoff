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

