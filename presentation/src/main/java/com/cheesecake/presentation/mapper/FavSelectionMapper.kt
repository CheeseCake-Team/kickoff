package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.screens.favoritecompetitionsselection.SelectedCompetitionItemUiState
import com.cheesecake.presentation.screens.favoriteteamsselection.SelectedTeamItemUiState

@JvmName("competitionToCompetitionUIState")
fun Competition.toUiState(
    onCompetitionClick: () -> Unit
): SelectedCompetitionItemUiState {
    return SelectedCompetitionItemUiState(
        competitionId = this.competitionId,
        imageUrl = this.imageUrl,
        competitionName = this.name,
        onClick = onCompetitionClick
    )
}

@JvmName("competitionsToCompetitionsUIState")
fun List<Competition>.toUiState(
    onCompetitionClick: (Competition) -> Unit
): List<SelectedCompetitionItemUiState> {
    return this.map { competition ->
        competition.toUiState { onCompetitionClick(competition) }
    }
}

@JvmName("teamToTeamUiState")
fun Team.toUiState(
    onTeamClick: () -> Unit
): SelectedTeamItemUiState {
    return SelectedTeamItemUiState(
        teamId = this.id,
        imageUrl = this.imageUrl,
        teamName = this.name,
        isSelected = this.isFavourite,
        onClick = onTeamClick
    )
}

@JvmName("teamsToTeamsUiState")
fun List<Team>.toUiState(
    onTeamClick: (Team) -> Unit
): List<SelectedTeamItemUiState> {
    return this.map { team ->
        team.toUiState { onTeamClick(team) }
    }
}