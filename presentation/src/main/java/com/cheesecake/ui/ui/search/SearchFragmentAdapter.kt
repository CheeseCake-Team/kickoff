package com.cheesecake.ui.ui.search

import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter
import com.cheesecake.ui.models.TeamUIState

class SearchFragmentAdapter : BaseAdapter<TeamUIState>(null) {
    override val layoutId = R.layout.item_team
}