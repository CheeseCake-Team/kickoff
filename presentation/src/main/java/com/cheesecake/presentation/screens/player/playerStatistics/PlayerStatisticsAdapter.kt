package com.cheesecake.presentation.screens.player.playerStatistics

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class PlayerStatisticsAdapter: BaseListAdapter<PlayerSectionItemUIState>(PlayerSectionItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_statistics_block

}

class PlayerSectionItemUIStateDiffUtil: DiffUtil.ItemCallback<PlayerSectionItemUIState>() {
    override fun areItemsTheSame(
        oldItem: PlayerSectionItemUIState,
        newItem: PlayerSectionItemUIState
    ): Boolean = oldItem.header == newItem.header

    override fun areContentsTheSame(
        oldItem: PlayerSectionItemUIState,
        newItem: PlayerSectionItemUIState
    ): Boolean = oldItem == newItem

}