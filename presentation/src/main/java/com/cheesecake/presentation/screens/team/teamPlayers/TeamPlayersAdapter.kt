package com.cheesecake.presentation.screens.team.teamPlayers

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamPlayersAdapter: BaseListAdapter<SquadPlayerItemUiState>(SquadPlayerItemUIStateDiffUtils()) {
    override val layoutId = R.layout.item_team_player
}

class SquadPlayerItemUIStateDiffUtils : DiffUtil.ItemCallback<SquadPlayerItemUiState>() {
    override fun areItemsTheSame(oldItem: SquadPlayerItemUiState, newItem: SquadPlayerItemUiState): Boolean =
        oldItem.number == newItem.number

    override fun areContentsTheSame(oldItem: SquadPlayerItemUiState, newItem: SquadPlayerItemUiState): Boolean =
        oldItem == newItem
}