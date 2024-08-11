package com.cheesecake.presentation.screens.search.adapters

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.screens.search.models.TeamSearchItemUiState

class SearchTeamAdapter : BaseAdapter<TeamSearchItemUiState>(null) {
    override val layoutId = R.layout.item_team_search_item
}