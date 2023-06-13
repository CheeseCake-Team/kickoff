package com.cheesecake.presentation.ui.favoriteLeagues

import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class FavoriteLeaguesAdapter: BaseAdapter<League>(null) {
    override val layoutId = R.layout.item_favorite_team
}