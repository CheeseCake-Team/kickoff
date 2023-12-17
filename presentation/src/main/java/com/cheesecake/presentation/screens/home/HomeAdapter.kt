package com.cheesecake.presentation.screens.home

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class HomeAdapter: BaseListAdapter<FavoriteHomeItemUIState>(FavoriteHomeItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_league_followed_with_matches
}

class FavoriteHomeItemUIStateDiffUtil: DiffUtil.ItemCallback<FavoriteHomeItemUIState>() {
    override fun areItemsTheSame(oldItem: FavoriteHomeItemUIState, newItem: FavoriteHomeItemUIState): Boolean =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: FavoriteHomeItemUIState, newItem: FavoriteHomeItemUIState): Boolean =
        oldItem == newItem
}