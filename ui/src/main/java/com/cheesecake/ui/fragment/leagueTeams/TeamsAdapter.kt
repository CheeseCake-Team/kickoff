package com.cheesecake.ui.fragment.leagueTeams


import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter
import com.cheesecake.ui.models.TeamUIState

class TeamsAdapter : BaseAdapter<TeamUIState>(null) {
    override val layoutId = R.layout.item_team
}