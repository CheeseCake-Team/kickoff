package com.cheesecake.presentation.screens.competition.competitionmatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.screens.home.MatchItemUiState

class CompetitionMatchesHeadToHeadAdapter :
    BaseListAdapter<MatchItemUiState>(MatchItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_head_to_head
}

class MatchItemUIStateDiffUtil : DiffUtil.ItemCallback<MatchItemUiState>() {
    override fun areItemsTheSame(oldItem: MatchItemUiState, newItem: MatchItemUiState): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: MatchItemUiState, newItem: MatchItemUiState): Boolean =
        oldItem == newItem
}