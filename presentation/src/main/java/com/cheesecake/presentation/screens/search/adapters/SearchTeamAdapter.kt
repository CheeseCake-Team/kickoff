package com.cheesecake.presentation.screens.search.adapters

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.screens.search.models.TeamSearchUIState

class SearchTeamAdapter : BaseAdapter<TeamSearchUIState>(null) {
    override val layoutId = R.layout.item_team_search_item
}