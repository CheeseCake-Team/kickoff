package com.cheesecake.presentation.ui.leagueDetails

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class LeagueDetailsTopScorersAdapter :BaseAdapter<PlayerStatistics>(null) {
    override val layoutId = R.layout.item_player_goals
}