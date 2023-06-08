package com.cheesecake.ui.fragment.leagueDetails

import com.cheesecake.domain.entity.PlayerStatisticsEntity
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class LeagueDetailsTopScorersAdapter :BaseAdapter<PlayerStatisticsEntity>(null) {
    override val layoutId = R.layout.item_player_goals
}