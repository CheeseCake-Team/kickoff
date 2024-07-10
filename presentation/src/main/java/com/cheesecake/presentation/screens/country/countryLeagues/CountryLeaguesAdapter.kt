package com.cheesecake.presentation.screens.country.countryLeagues

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class CountryLeaguesAdapter: BaseListAdapter<CompetitionItemUiState>(LeagueItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_league_for_country
}

class LeagueItemUIStateDiffUtil: DiffUtil.ItemCallback<CompetitionItemUiState>() {

    override fun areItemsTheSame(oldItem: CompetitionItemUiState, newItem: CompetitionItemUiState): Boolean =
        oldItem.competitionName == newItem.competitionName

    override fun areContentsTheSame(
        oldItem: CompetitionItemUiState,
        newItem: CompetitionItemUiState
    ): Boolean = oldItem == newItem

}