package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("league_table")
data class LeagueLocalDto(
    @PrimaryKey val leagueId: Int,
    val leagueName: String,
    val leagueSeason: String,
    val leagueLogoUrl: String,
    val isFavourite: Boolean
)