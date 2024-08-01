package com.cheesecake.presentation.screens.favorite.favoritecompetitions

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class FavoriteCompetitionsAdapter : BaseListAdapter<FavoriteCompetitionsUiState>(CompetitionsUIStateDiffUtil()) {
    override val layoutId = R.layout.item_favorite_leagues
}

class CompetitionsUIStateDiffUtil : DiffUtil.ItemCallback<FavoriteCompetitionsUiState>() {
    override fun areItemsTheSame(
        oldItem: FavoriteCompetitionsUiState,
        newItem: FavoriteCompetitionsUiState
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: FavoriteCompetitionsUiState,
        newItem: FavoriteCompetitionsUiState
    ): Boolean = oldItem == newItem

}