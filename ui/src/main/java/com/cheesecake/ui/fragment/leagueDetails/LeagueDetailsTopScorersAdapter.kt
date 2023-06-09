package com.cheesecake.ui.fragment.leagueDetails

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class LeagueDetailsTopScorersAdapter :BaseAdapter<PlayerStatistics>(null) {
    override val layoutId = R.layout.item_player_goals
}