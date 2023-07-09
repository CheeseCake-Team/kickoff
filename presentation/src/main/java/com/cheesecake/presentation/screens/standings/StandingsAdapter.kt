package com.cheesecake.presentation.screens.standings

import androidx.recyclerview.widget.DiffUtil
import  com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter


class StandingsAdapter : BaseListAdapter<TeamStandingItemUIState>(TeamStandingItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_standing
}

class TeamStandingItemUIStateDiffUtil: DiffUtil.ItemCallback<TeamStandingItemUIState>() {
    override fun areItemsTheSame(
        oldItem: TeamStandingItemUIState,
        newItem: TeamStandingItemUIState
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: TeamStandingItemUIState,
        newItem: TeamStandingItemUIState
    ): Boolean = oldItem == newItem

}