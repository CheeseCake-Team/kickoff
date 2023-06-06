package com.cheesecake.ui.fragment.leagueTeams.adapter

import com.cheesecake.domain.Entity.Team
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class TeamsAdapter: BaseAdapter<Team>(null) {
    override val layoutId: Int
        get() = R.layout.item_team
}