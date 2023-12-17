package com.cheesecake.presentation.screens.competition.competitiondetails

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class CompetitionDetailsTopScorersAdapter :
    BaseListAdapter<PlayerStatisticsItemUiState>(PlayerStatisticsItemUiStateDiffUtils()) {
    override val layoutId = R.layout.item_player_goals
}

class PlayerStatisticsItemUiStateDiffUtils : DiffUtil.ItemCallback<PlayerStatisticsItemUiState>() {
    override fun areItemsTheSame(
        oldItem: PlayerStatisticsItemUiState,
        newItem: PlayerStatisticsItemUiState
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: PlayerStatisticsItemUiState,
        newItem: PlayerStatisticsItemUiState
    ): Boolean = oldItem == newItem
}