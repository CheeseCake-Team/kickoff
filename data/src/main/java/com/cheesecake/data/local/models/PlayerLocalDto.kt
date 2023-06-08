package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
data class PlayerLocalDto(
    @PrimaryKey val playerId: Int,
    val name: String,
    val age: Int,
    val nationality: String,
    val photo: String,
    val isFavourite: Boolean = false,
)
