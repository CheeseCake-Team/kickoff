package com.cheesecake.domain.entity



data class PlayerStatisticsEntity(
    val id: Int,
    val name: String,
    val firstname: String,
    val lastname: String,
    val age: Int,
    val date: String,
    val place: String,
    val country: String,
    val nationality: String,
    val height: String,
    val weight: String,
    val injured: Boolean,
    val photo: String,
    val appearences: Int,
    val lineups: Int,
    val minutes: Int,
    val number: Any,
    val position: String,
    val rating: String,
    val captain: Boolean
)



