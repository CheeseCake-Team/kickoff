package com.cheesecake.presentation.screens.teamPlayers


import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamPLayersPositionsAdapter : BaseListAdapter<Pair<String,List<PlayerStatistics>>>(
    DateTeamPlayersPositionDiffUtil(),
    null
){
    override val layoutId = R.layout.item_team_players_positions
}
class DateTeamPlayersPositionDiffUtil() : DiffUtil.ItemCallback<Pair<String, List<PlayerStatistics>>>() {

    override fun areItemsTheSame(
        oldItem: Pair<String, List<PlayerStatistics>>,
        newItem: Pair<String, List<PlayerStatistics>>
    ): Boolean = oldItem.first == newItem.first

    override fun areContentsTheSame(
        oldItem: Pair<String, List<PlayerStatistics>>,
        newItem: Pair<String, List<PlayerStatistics>>
    ): Boolean = oldItem.second == newItem.second

}