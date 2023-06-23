package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("team_country_table")
data class TeamCountriesLocalDTO(
    @PrimaryKey val name: String,
    val flagImageUrl: String,
)