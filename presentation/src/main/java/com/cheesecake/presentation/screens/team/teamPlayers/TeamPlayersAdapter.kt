package com.cheesecake.presentation.screens.team.teamPlayers

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamPlayersAdapter: BaseListAdapter<SquadPlayerItemUIState>(SquadPlayerItemUIStateDiffUtils()) {
    override val layoutId = R.layout.item_team_player
}

class SquadPlayerItemUIStateDiffUtils : DiffUtil.ItemCallback<SquadPlayerItemUIState>() {
    override fun areItemsTheSame(oldItem: SquadPlayerItemUIState, newItem: SquadPlayerItemUIState): Boolean =
        oldItem.number == newItem.number

    override fun areContentsTheSame(oldItem: SquadPlayerItemUIState, newItem: SquadPlayerItemUIState): Boolean =
        oldItem == newItem

}