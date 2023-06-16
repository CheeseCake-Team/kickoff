package com.cheesecake.presentation.screens.home

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class MatchesAdapter: BaseListAdapter<MatchItemUIState>(MatchItemUIStateDiffUtil()){
    override val layoutId = R.layout.item_league_followed_with_matches
}

class MatchItemUIStateDiffUtil: DiffUtil.ItemCallback<MatchItemUIState>() {
    override fun areItemsTheSame(oldItem: MatchItemUIState, newItem: MatchItemUIState): Boolean =
        oldItem.leagueId == newItem.leagueId && newItem.leagueSeason == oldItem.leagueSeason

    override fun areContentsTheSame(oldItem: MatchItemUIState, newItem: MatchItemUIState): Boolean =
        oldItem == newItem

}