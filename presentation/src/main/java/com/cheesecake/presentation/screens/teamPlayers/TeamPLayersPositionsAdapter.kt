package com.cheesecake.presentation.screens.teamPlayers


import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamPLayersPositionsAdapter : BaseListAdapter<Pair<String,List<SquadPlayer>>>(
    DateTeamPlayersPositionDiffUtil(),
    null
){
    override val layoutId = R.layout.item_team_players_positions
}
class DateTeamPlayersPositionDiffUtil() : DiffUtil.ItemCallback<Pair<String, List<SquadPlayer>>>() {

    override fun areItemsTheSame(
        oldItem: Pair<String, List<SquadPlayer>>,
        newItem: Pair<String, List<SquadPlayer>>
    ): Boolean = oldItem.first == newItem.first

    override fun areContentsTheSame(
        oldItem: Pair<String, List<SquadPlayer>>,
        newItem: Pair<String, List<SquadPlayer>>
    ): Boolean = oldItem.second == newItem.second

}