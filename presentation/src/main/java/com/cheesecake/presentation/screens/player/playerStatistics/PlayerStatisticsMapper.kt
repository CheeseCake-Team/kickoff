package com.cheesecake.presentation.screens.player.playerStatistics

import com.cheesecake.domain.entity.PlayerStatistics

@JvmName("playerStatisticsToUiState")
fun PlayerStatistics.toUiState(): List<PlayerSectionItemUiState> {
    return listOf(
        PlayerSectionItemUiState(
            "Personal Info", listOf(
                PlayerDataItemUiState("Name", this.name),
                PlayerDataItemUiState("Age", this.age.toString()),
                PlayerDataItemUiState("Birth Date", this.birthDate),
                PlayerDataItemUiState("Birth Place", this.birthPlace ?: "Not assigned"),
                PlayerDataItemUiState("Birth Country", this.birthCountry),
                PlayerDataItemUiState("Nationality", this.nationality),
                PlayerDataItemUiState("Height", this.heightInCm),
                PlayerDataItemUiState("Weight", this.weightInKg),
                PlayerDataItemUiState("Injured", if (this.isInjured) "Yes" else "No"),
                PlayerDataItemUiState("Rating", this.rating),
                PlayerDataItemUiState("Captain", if (this.isCaptain) "Yes" else "No")
            )
        ),
        PlayerSectionItemUiState(
            "Games Info", listOf(
                PlayerDataItemUiState("Appearances", appearances.toString()),
                PlayerDataItemUiState("Lineups", lineups.toString()),
                PlayerDataItemUiState("Minutes", if (minutes == -1) "NA" else minutes.toString()),
                PlayerDataItemUiState(
                    "Games Number",
                    if (number == -1) "NA" else number.toString()
                ),
                PlayerDataItemUiState("Position", position),
            )
        ),
        PlayerSectionItemUiState(
            "Goals Info", listOf(
                PlayerDataItemUiState("goals", if (goals == -1) "NA" else goals.toString()),
            )
        )
    )
}