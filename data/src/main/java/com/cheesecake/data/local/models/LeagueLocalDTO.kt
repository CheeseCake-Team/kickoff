package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("league_table")
data class LeagueLocalDTO(
    @PrimaryKey val leagueId: Int,
    val leagueName: String,
    val leagueSeason: Int,
    val leagueLogoUrl: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val country: String,
    val isFavourite: Boolean,
    val typeName: String
)