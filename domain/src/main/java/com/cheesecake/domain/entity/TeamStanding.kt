package com.cheesecake.domain.entity

data class TeamStanding(
    val teamId: Int,
    val rank: Int,
    val form: List<String>,
    val name: String,
    val logo: String,
    val played: Int,
    val won: Int,
    val draw: Int,
    val lose: Int,
    val points: Int,
    val goalsForAgainst: String,
)