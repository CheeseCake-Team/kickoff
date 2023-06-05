package com.cheesecake.ui.fragment.leagueTeams.adapter

import com.cheesecake.domain.models.TeamEntity
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class TeamsAdapter: BaseAdapter<TeamEntity>(null) {
    override val layoutId: Int
        get() = R.layout.item_team
}