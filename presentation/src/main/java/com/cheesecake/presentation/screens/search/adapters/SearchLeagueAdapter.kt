package com.cheesecake.presentation.screens.search.adapters

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.screens.search.models.CompetitionSearchUiState

class SearchLeagueAdapter: BaseAdapter<CompetitionSearchUiState>(null) {

    override val layoutId: Int = R.layout.item_competition

}