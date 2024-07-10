package com.cheesecake.presentation.screens.team.teamPlayers

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamPlayersPositionsAdapter
    : BaseListAdapter<Pair<String, List<SquadPlayerItemUiState>>>(
    DateTeamPlayersPositionDiffUtil()
) {
    override val layoutId = R.layout.item_team_players_positions
}

class DateTeamPlayersPositionDiffUtil() :
    DiffUtil.ItemCallback<Pair<String, List<SquadPlayerItemUiState>>>() {

    override fun areItemsTheSame(
        oldItem: Pair<String, List<SquadPlayerItemUiState>>,
        newItem: Pair<String, List<SquadPlayerItemUiState>>
    ): Boolean = oldItem.first == newItem.first

    override fun areContentsTheSame(
        oldItem: Pair<String, List<SquadPlayerItemUiState>>,
        newItem: Pair<String, List<SquadPlayerItemUiState>>
    ): Boolean = oldItem.second == newItem.second
}