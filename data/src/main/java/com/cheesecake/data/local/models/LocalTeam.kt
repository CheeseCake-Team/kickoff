package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cheesecake.data.models.TeamInformationResponse

@Entity(tableName = "team_table")
data class LocalTeam(
    @PrimaryKey val teamId: Int,
    val teamName: String,
    val founded: Int,
    val teamCountry: String,
    val venueCapacity: Int,
    val venueName: String,
    val imageUrl: String
)


