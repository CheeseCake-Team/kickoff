package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cheesecake.data.models.base.LeagueTypeLogo
import com.cheesecake.data.models.dto.CountryDto
import com.cheesecake.data.models.dto.LeagueDTO

@Entity(tableName = "league_table")

data class LeagueLocalDto(

    @PrimaryKey val league: LeagueTypeLogo,
    val country: CountryDto,
    val seasons: List<LeagueDTO.Season>,

    )