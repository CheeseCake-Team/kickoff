package com.cheesecake.presentation.ui.search

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.models.TeamUIState

class SearchTeamAdapter : BaseAdapter<TeamUIState>(null) {
    override val layoutId = R.layout.item_team
}