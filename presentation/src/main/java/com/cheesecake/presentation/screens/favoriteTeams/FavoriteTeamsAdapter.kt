package com.cheesecake.presentation.screens.favoriteTeams

import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class FavoriteTeamsAdapter:BaseAdapter<Team>(null) {
    override val layoutId = R.layout.item_favorite_team
}