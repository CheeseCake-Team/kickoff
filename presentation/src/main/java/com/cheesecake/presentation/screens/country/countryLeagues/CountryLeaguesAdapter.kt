package com.cheesecake.presentation.screens.country.countryLeagues

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.screens.league.LeagueItemUIState

class CountryLeaguesAdapter: BaseListAdapter<LeagueItemUIState>(LeagueItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_league_for_country
}

class LeagueItemUIStateDiffUtil: DiffUtil.ItemCallback<LeagueItemUIState>() {

    override fun areItemsTheSame(oldItem: LeagueItemUIState, newItem: LeagueItemUIState): Boolean =
        oldItem.leagueName == newItem.leagueName

    override fun areContentsTheSame(
        oldItem: LeagueItemUIState,
        newItem: LeagueItemUIState
    ): Boolean = oldItem == newItem

}