package com.cheesecake.presentation.screens.teamPlayers

import com.cheesecake.domain.entity.Squad
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class TeamPlayerAdapter: BaseAdapter<Squad>(null) {
    override val layoutId = R.layout.item_team_player
}