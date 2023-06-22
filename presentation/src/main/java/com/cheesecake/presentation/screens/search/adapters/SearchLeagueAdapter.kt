package com.cheesecake.presentation.screens.search.adapters

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.screens.search.models.LeagueSearchUIState

class SearchLeagueAdapter: BaseAdapter<LeagueSearchUIState>(null) {

    override val layoutId: Int = R.layout.item_league

}