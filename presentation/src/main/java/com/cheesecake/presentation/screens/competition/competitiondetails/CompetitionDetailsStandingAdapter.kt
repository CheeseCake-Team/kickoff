package com.cheesecake.presentation.screens.competition.competitiondetails

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class CompetitionDetailsStandingAdapter :
    BaseListAdapter<TeamStandingItemUiState>(TeamStandingItemUiStateDiffUtils()) {
    override val layoutId = R.layout.item_club_scores
}

class TeamStandingItemUiStateDiffUtils : DiffUtil.ItemCallback<TeamStandingItemUiState>() {
    override fun areItemsTheSame(
        oldItem: TeamStandingItemUiState,
        newItem: TeamStandingItemUiState
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: TeamStandingItemUiState,
        newItem: TeamStandingItemUiState
    ): Boolean = oldItem.name == newItem.name
}