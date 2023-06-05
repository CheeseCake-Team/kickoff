package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_table")

data class FavouriteTeamLocalDto(
    @PrimaryKey val teamId: Int,
    val teamName: String,
    val teamCountry: String,
    val imageUrl: String,
)