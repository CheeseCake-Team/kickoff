package com.cheesecake.presentation.screens.home

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class HomeAdapter: BaseListAdapter<FavoriteHomeItemUiState>(FavoriteHomeItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_league_followed_with_matches
}

class FavoriteHomeItemUIStateDiffUtil: DiffUtil.ItemCallback<FavoriteHomeItemUiState>() {
    override fun areItemsTheSame(oldItem: FavoriteHomeItemUiState, newItem: FavoriteHomeItemUiState): Boolean =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: FavoriteHomeItemUiState, newItem: FavoriteHomeItemUiState): Boolean =
        oldItem == newItem
}