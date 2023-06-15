package com.cheesecake.presentation.screens.teamPlayers

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamPlayerAdapter: BaseListAdapter<PlayerStatistics>(
    PlayerDiffUtils(),
    null
) {
    override val layoutId = R.layout.item_team_player
}

class PlayerDiffUtils : DiffUtil.ItemCallback<PlayerStatistics>() {
    override fun areItemsTheSame(oldItem: PlayerStatistics, newItem: PlayerStatistics): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PlayerStatistics, newItem: PlayerStatistics): Boolean =
        oldItem == newItem

}