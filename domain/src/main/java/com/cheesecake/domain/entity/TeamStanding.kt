package com.cheesecake.domain.entity

data class TeamStanding(
    val teamId: Int,
    val form: String,
    val name: String,
    val logo: String,
    val played: String,
    val won: String,
    val draw: String,
    val lose: String,
    val points: String
)