package com.cheesecake.presentation.screens.player.playerStatistics

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class SectionItemAdapter: BaseListAdapter<PlayerDataItemUiState>(PlayerDataItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_statistics_section

}

class PlayerDataItemUIStateDiffUtil: DiffUtil.ItemCallback<PlayerDataItemUiState>() {
    override fun areItemsTheSame(
        oldItem: PlayerDataItemUiState,
        newItem: PlayerDataItemUiState
    ): Boolean = oldItem.section == newItem.section

    override fun areContentsTheSame(
        oldItem: PlayerDataItemUiState,
        newItem: PlayerDataItemUiState
    ): Boolean = oldItem == newItem

}