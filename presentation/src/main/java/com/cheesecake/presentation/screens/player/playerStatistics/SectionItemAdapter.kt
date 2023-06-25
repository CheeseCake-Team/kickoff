package com.cheesecake.presentation.screens.player.playerStatistics

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class SectionItemAdapter: BaseListAdapter<PlayerDataItemUIState>(PlayerDataItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_statistics_section

}

class PlayerDataItemUIStateDiffUtil: DiffUtil.ItemCallback<PlayerDataItemUIState>() {
    override fun areItemsTheSame(
        oldItem: PlayerDataItemUIState,
        newItem: PlayerDataItemUIState
    ): Boolean = oldItem.section == newItem.section

    override fun areContentsTheSame(
        oldItem: PlayerDataItemUIState,
        newItem: PlayerDataItemUIState
    ): Boolean = oldItem == newItem

}