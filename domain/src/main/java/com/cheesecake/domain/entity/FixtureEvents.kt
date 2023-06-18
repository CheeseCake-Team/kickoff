package com.cheesecake.domain.entity

data class FixtureEvents(
    val time: Int?,
    val teamId: Int,
    val playerId: Int,
    val playerName: String,
    val SubstituentPlayer: String?,
    val type: String,
    val detail: String?
)
