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