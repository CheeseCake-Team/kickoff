package com.cheesecake.presentation.screens.search.viewAll.teams

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.screens.search.models.TeamSearchUIState

class TeamsAdapter: BaseAdapter<TeamSearchUIState>(null) {

    override val layoutId: Int = R.layout.item_team_search_item
}