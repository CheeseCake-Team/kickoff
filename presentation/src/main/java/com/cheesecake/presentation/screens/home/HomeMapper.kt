package com.cheesecake.presentation.screens.home

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.mapper.toMatchUIState
import com.cheesecake.presentation.utils.toStanderDateString
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@JvmName("dateToDateItemUiState")
fun Date.toUiState(onClickDate: (date: Date) -> Unit): DateItemUiState {
    val dateFormat = SimpleDateFormat("MMM", Locale.ENGLISH)
    val month = dateFormat.format(this)

    val dayFormat = SimpleDateFormat("dd", Locale.ENGLISH)
    val day = dayFormat.format(this)

    val currentDayFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    val currentDay = currentDayFormat.format(Date())
    val thisDay = currentDayFormat.format(this)

    val isSelected = currentDay == thisDay

    return DateItemUiState(
        month = month,
        day = day,
        isSelected = isSelected,
        onClickDate = onClickDate,
        date = this
    )
}

@JvmName("datesToDateItemsUiState")
fun List<Date>.toUiState(onClickDate: (date: Date) -> Unit): List<DateItemUiState> =
    this.map { it.toUiState { date -> onClickDate(date) } }

@JvmName("pairsOfCompetitionsAndMatchesToUiState")
fun List<Pair<League, List<Fixture>>>.toUiState(
    onMatchClick: (homeTeamId: Int, awayTeamId: Int, date: String) -> Unit,
    onCompetitionClick: (competitionId: Int, season: Int) -> Unit
): List<FavoriteHomeItemUiState> {
    return map {
        FavoriteHomeItemUiState(
            title = it.first.name,
            imageUrl = it.first.imageUrl,
            competitionId = it.first.competitionId,
            season = it.first.season.last(),
            onclick = onCompetitionClick,
            isNoData = it.second.isEmpty(),
            matches = it.second.map { fixture ->
                fixture.toMatchUIState {
                    onMatchClick(
                        fixture.homeTeamID,
                        fixture.awayTeamID,
                        fixture.matchDate.toStanderDateString()
                    )
                }
            }
        )
    }
}