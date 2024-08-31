package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.screens.favoritecompetitionsselection.SelectedCompetitionItemUiState
import com.cheesecake.presentation.screens.favoriteteamsselection.SelectedTeamItemUiState

@JvmName("competitionToCompetitionUIState")
fun League.toUiState(
    onCompetitionClick: () -> Unit
): SelectedCompetitionItemUiState {
    return SelectedCompetitionItemUiState(
        competitionId = this.competitionId,
        imageUrl = this.imageUrl,
        competitionName = this.name,
        isSelected = this.isFavourite,
        onClick = onCompetitionClick
    )
}

@JvmName("competitionsToCompetitionsUIState")
fun List<League>.toUiState(
    onCompetitionClick: (League) -> Unit
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