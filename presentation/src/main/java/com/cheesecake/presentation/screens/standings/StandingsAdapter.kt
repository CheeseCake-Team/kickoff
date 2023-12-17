package com.cheesecake.presentation.screens.standings

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class StandingsAdapter :
    BaseListAdapter<TeamStandingItemUiState>(TeamStandingItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_standing
}

class TeamStandingItemUIStateDiffUtil : DiffUtil.ItemCallback<TeamStandingItemUiState>() {
    override fun areItemsTheSame(
        oldItem: TeamStandingItemUiState, newItem: TeamStandingItemUiState
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: TeamStandingItemUiState, newItem: TeamStandingItemUiState
    ): Boolean = oldItem == newItem
}