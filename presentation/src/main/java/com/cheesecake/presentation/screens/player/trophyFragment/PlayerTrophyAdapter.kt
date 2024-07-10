package com.cheesecake.presentation.screens.player.trophyFragment

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class PlayerTrophyAdapter : BaseListAdapter<PlayerTrophyItemUiState>(TrophyDiffUtil()) {
    override val layoutId: Int = R.layout.item_trophy
}

class TrophyDiffUtil : DiffUtil.ItemCallback<PlayerTrophyItemUiState>() {
    override fun areItemsTheSame(
        oldItem: PlayerTrophyItemUiState,
        newItem: PlayerTrophyItemUiState
    ): Boolean =
        oldItem.country == newItem.country

    override fun areContentsTheSame(
        oldItem: PlayerTrophyItemUiState,
        newItem: PlayerTrophyItemUiState
    ): Boolean = oldItem == newItem
}