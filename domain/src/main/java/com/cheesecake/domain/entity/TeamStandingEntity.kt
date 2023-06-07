package com.cheesecake.domain.entity

data class TeamStandingEntity(
    val teamId: Int,
    val season: Int,
    val form: String,
    val name: String,
    val logo: String,
    val played: Int,
    val won: Int,
    val draw: Int,
    val lose: Int,
    val points: Int
)