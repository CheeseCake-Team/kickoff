package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("competition")
data class CompetitionLocalDto(
    @PrimaryKey val id: Int,
    val name: String,
    val season: Int,
    val imageUrl: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val country: String,
    val typeName: String
)