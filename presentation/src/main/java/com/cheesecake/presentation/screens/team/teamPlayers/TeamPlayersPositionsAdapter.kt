package com.cheesecake.presentation.screens.team.teamPlayers

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

public class TeamPlayersPositionsAdapter
: BaseListAdapter<Pair<String, List<SquadPlayerItemUIState>>>(
DateTeamPlayersPositionDiffUtil(),
){
    override val layoutId = R.layout.item_team_players_positions
}
class DateTeamPlayersPositionDiffUtil() : DiffUtil.ItemCallback<Pair<String, List<SquadPlayerItemUIState>>>() {

    override fun areItemsTheSame(
        oldItem: Pair<String, List<SquadPlayerItemUIState>>,
        newItem: Pair<String, List<SquadPlayerItemUIState>>
    ): Boolean = oldItem.first == newItem.first

    override fun areContentsTheSame(
        oldItem: Pair<String, List<SquadPlayerItemUIState>>,
        newItem: Pair<String, List<SquadPlayerItemUIState>>
    ): Boolean = oldItem.second == newItem.second

}