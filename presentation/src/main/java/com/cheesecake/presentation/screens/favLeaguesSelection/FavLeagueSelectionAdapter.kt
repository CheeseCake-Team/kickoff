package com.cheesecake.presentation.screens.favLeaguesSelection

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class FavLeagueSelectionAdapter : BaseAdapter<League>(null) {
    override val layoutId = R.layout.item_select_fav
}