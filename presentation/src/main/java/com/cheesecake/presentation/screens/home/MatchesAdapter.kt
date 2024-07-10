package com.cheesecake.presentation.screens.home

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class MatchesAdapter : BaseListAdapter<MatchItemUiState>(MatchItemUiStateDiffUtil()) {
    override val layoutId = R.layout.item_match
}

class MatchItemUiStateDiffUtil : DiffUtil.ItemCallback<MatchItemUiState>() {
    override fun areItemsTheSame(oldItem: MatchItemUiState, newItem: MatchItemUiState): Boolean =
        oldItem.awayTeamName == newItem.awayTeamName

    override fun areContentsTheSame(oldItem: MatchItemUiState, newItem: MatchItemUiState): Boolean =
        oldItem == newItem
}