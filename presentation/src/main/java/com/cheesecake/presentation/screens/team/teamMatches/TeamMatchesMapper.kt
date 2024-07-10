package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.screens.home.MatchItemUiState
import com.cheesecake.presentation.utils.toStanderDateString
import com.cheesecake.presentation.utils.toStanderTimeString

@JvmName("fixtureToTeamMatchUiState")
fun Fixture.toUiState(
    onMatchClicked: (Int, Int, String) -> Unit,
    onCompetitionClicked: (Int, Int) -> Unit
): TeamMatchItemUiState =
    TeamMatchItemUiState(
        MatchItemUiState(
            matchState,
            matchDate.toStanderDateString(),
            matchDate.toStanderTimeString(),
            homeTeamName,
            awayTeamName,
            homeTeamGoals ?: "0",
            awayTeamGoals ?: "0",
            homeTeamLogoUrl,
            awayTeamLogoUrl,
            onMatchClicked = {
                onMatchClicked(
                    homeTeamID,
                    awayTeamID,
                    matchDate.toStanderDateString()
                )
            },
        ),
        leagueName,
        leagueLogoUrl,
        onCompetitionClicked = {
            onCompetitionClicked(
                competitionId,
                leagueSeason
            )
        }
    )

@JvmName("fixturesToTeamMatchesUiState")
fun List<Fixture>.toUiState(
    onMatchClicked: (Int, Int, String) -> Unit,
    onCompetitionClicked: (Int, Int) -> Unit
): List<TeamMatchItemUiState> = this.map { it.toUiState(onMatchClicked, onCompetitionClicked) }