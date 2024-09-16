package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "favorite_competition",
    primaryKeys = ["competitionId"],
    foreignKeys = [ForeignKey(
        entity = CompetitionLocalDto::class,
        parentColumns = ["id"],
        childColumns = ["competitionId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class FavoriteCompetition(
    val competitionId: Int
)
