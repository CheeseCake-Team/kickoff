package com.cheesecake.presentation.screens.player.playerStatistics

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class PlayerStatisticsAdapter :
    BaseListAdapter<PlayerSectionItemUiState>(PlayerSectionItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_statistics_block
}

class PlayerSectionItemUIStateDiffUtil : DiffUtil.ItemCallback<PlayerSectionItemUiState>() {
    override fun areItemsTheSame(
        oldItem: PlayerSectionItemUiState, newItem: PlayerSectionItemUiState
    ): Boolean = oldItem.header == newItem.header

    override fun areContentsTheSame(
        oldItem: PlayerSectionItemUiState, newItem: PlayerSectionItemUiState
    ): Boolean = oldItem == newItem
}