package com.cheesecake.domain.models

data class Standings(
    val flag: String,
    val name: String,
    val played: Int,
    val won: Int,
    val draw: Int,
    val lose: Int,
    val points: Int
)