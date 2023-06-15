package com.cheesecake.presentation.screens.favoriteLeagues

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class FavoriteLeaguesAdapter : BaseListAdapter<FavoriteLeagueUIState>(LeagueUIStateDiffUtil()) {
    override val layoutId = R.layout.item_favorite_leagues
}

class LeagueUIStateDiffUtil : DiffUtil.ItemCallback<FavoriteLeagueUIState>() {
    override fun areItemsTheSame(
        oldItem: FavoriteLeagueUIState,
        newItem: FavoriteLeagueUIState
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: FavoriteLeagueUIState,
        newItem: FavoriteLeagueUIState
    ): Boolean = oldItem == newItem

}