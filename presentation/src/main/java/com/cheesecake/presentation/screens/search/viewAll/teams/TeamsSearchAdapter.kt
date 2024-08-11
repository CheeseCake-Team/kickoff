package com.cheesecake.presentation.screens.search.viewAll.teams

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.screens.search.models.TeamSearchItemUiState

class TeamsSearchAdapter: BaseAdapter<TeamSearchItemUiState>(null) {

    override val layoutId: Int = R.layout.item_team_search_item
}