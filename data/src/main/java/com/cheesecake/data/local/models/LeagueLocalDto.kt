package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_table")

data class LeagueLocalDto(

    @PrimaryKey val league: com.cheesecake.data.repository.models.base.LeagueTypeLogo,
    val country: com.cheesecake.data.repository.models.dto.CountryDto,
    val seasons: List<com.cheesecake.data.repository.models.dto.LeagueDTO.Season>,

    )