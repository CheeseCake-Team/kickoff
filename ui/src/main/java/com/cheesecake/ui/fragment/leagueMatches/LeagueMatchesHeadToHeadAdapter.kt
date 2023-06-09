package com.cheesecake.ui.fragment.leagueMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class LeagueMatchesHeadToHeadAdapter : BaseAdapter<Fixture>(null) {
    override val layoutId = R.layout.item_head_to_head
}