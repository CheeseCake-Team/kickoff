package com.cheesecake.presentation.screens.league.leagueTeams


import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.models.TeamUIState

class TeamsAdapter : BaseAdapter<TeamUIState>(null) {
    override val layoutId = R.layout.item_team
}