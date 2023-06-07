package com.cheesecake.domain.entity

data class PlayerEntity(
    val id: Int,
    val teamLogo: String,
    val playerName: String,
    val playerPhoto: String,
    val playerRate: String,
    val playerNumber: Int,
    val minutesPlayed: Int,
    val goals: Int?,
    val assists: Int?,
    val touches: Int?,
    val keyPasses: Int?,
    val totalShots: Int,
    val shotsOnTarget: Int,
    val tackles: Int,
    val interceptions: Int,
    val blockedShots: Int,
    val fouls: Int,
    val wasFouled: Int,
    val yellowCards: Int,
    val redCards: Int
)