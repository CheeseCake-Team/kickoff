package com.cheesecake.presentation.screens.competition.competitiondetails

data class CompetitionDetailsUiState(
    val countryName: String = "",
    val round: String = "",
    val teamsCount: String = "",
    val teamsStanding: List<TeamStandingItemUiState> = emptyList(),
    val topPlayers: List<PlayerStatisticsItemUiState> = emptyList(),
    val isTopPlayersEmpty: Boolean = false,
    val isTeamsStandingEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)