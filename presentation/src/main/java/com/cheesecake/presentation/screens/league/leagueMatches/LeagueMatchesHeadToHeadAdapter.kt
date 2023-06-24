package com.cheesecake.presentation.screens.league.leagueMatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.screens.home.MatchItemUIState

class LeagueMatchesHeadToHeadAdapter : BaseListAdapter<MatchItemUIState>(MatchItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_head_to_head
}

class MatchItemUIStateDiffUtil : DiffUtil.ItemCallback<MatchItemUIState>() {
    override fun areItemsTheSame(oldItem: MatchItemUIState, newItem: MatchItemUIState): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: MatchItemUIState, newItem: MatchItemUIState): Boolean =
        oldItem == newItem

}