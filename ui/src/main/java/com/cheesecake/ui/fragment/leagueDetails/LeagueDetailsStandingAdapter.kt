package com.cheesecake.ui.fragment.leagueDetails

import com.cheesecake.domain.entity.TeamStandingEntity
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class LeagueDetailsStandingAdapter :BaseAdapter<TeamStandingEntity>(null) {
    override val layoutId = R.layout.item_club_scores
}