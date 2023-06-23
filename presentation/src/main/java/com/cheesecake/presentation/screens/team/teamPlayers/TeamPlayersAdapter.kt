package com.cheesecake.presentation.screens.team.teamPlayers

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamPlayersAdapter: BaseListAdapter<SquadPlayer>(
    PlayerDiffUtils(),

    ) {
    override val layoutId = R.layout.item_team_player
}

class PlayerDiffUtils : DiffUtil.ItemCallback<SquadPlayer>() {
    override fun areItemsTheSame(oldItem: SquadPlayer, newItem: SquadPlayer): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SquadPlayer, newItem: SquadPlayer): Boolean =
        oldItem == newItem

}