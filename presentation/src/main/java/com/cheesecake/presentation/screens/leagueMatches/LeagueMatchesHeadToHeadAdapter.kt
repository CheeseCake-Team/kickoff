package com.cheesecake.presentation.screens.leagueMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class LeagueMatchesHeadToHeadAdapter : BaseAdapter<Fixture>(null) {
    override val layoutId = R.layout.item_head_to_head
}