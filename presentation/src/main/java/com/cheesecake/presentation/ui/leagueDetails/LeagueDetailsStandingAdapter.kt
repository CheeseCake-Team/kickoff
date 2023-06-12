package com.cheesecake.presentation.ui.leagueDetails

import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class LeagueDetailsStandingAdapter :BaseAdapter<TeamStanding>(null) {
    override val layoutId = R.layout.item_club_scores
}