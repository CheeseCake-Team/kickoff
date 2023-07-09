package com.cheesecake.presentation.screens.league.leagueTeams


import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.models.TeamUIState

class TeamsAdapter : BaseListAdapter<TeamUIState>(TeamUIStateDiffUtils()) {
    override val layoutId = R.layout.item_team
}

class TeamUIStateDiffUtils: DiffUtil.ItemCallback<TeamUIState>() {
    override fun areItemsTheSame(oldItem: TeamUIState, newItem: TeamUIState): Boolean =
        oldItem.teamName == newItem.teamName

    override fun areContentsTheSame(oldItem: TeamUIState, newItem: TeamUIState): Boolean =
        oldItem == newItem

}