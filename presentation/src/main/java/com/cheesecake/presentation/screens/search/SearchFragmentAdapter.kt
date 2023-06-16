package com.cheesecake.presentation.screens.search

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.models.TeamUIState

class SearchFragmentAdapter : BaseAdapter<TeamUIState>(null) {
    override val layoutId = R.layout.item_team
}