package com.cheesecake.ui.fragment.leagueTeams


import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class TeamsAdapter: BaseAdapter<TeamEntity>(null) {
    override val layoutId: Int
        get() = R.layout.item_team
}