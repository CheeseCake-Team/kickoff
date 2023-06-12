package com.cheesecake.ui.ui.leagueDetails

import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class LeagueDetailsStandingAdapter :BaseAdapter<TeamStanding>(null) {
    override val layoutId = R.layout.item_club_scores
}