package com.cheesecake.ui.fragment.leagueMatches

import com.cheesecake.domain.entity.FixtureEntity
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class LeagueMatchesHeadToHeadAdapter : BaseAdapter<FixtureEntity>(null) {
    override val layoutId = R.layout.item_head_to_head
}