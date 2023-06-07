package com.cheesecake.domain.entity

data class StandingsEntity(
    val flag: String,
    val name: String,
    val played: Int,
    val won: Int,
    val draw: Int,
    val lose: Int,
    val points: Int
)