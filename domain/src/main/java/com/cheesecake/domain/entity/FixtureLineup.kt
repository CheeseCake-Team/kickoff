package com.cheesecake.domain.entity

data class FixtureLineup(
    val teamId: Int,
    val teamName: String,
    val teamLogoUrl: String,
    val coachId: Int,
    val coachName: String,
    val coachImageUrl: String,
    val formation: String,
    val playerLineup: List<PlayerLineup>,
    val substitutesPlayers: List<PlayerLineup>
)

data class PlayerLineup(
    val playerId: Int,
    val playerName: String,
    val playerNumber: Int,
    val playerPosition: String,
    val playerPositionGrid: String?,
)
