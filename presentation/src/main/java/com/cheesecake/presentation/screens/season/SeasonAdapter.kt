package com.cheesecake.presentation.screens.season

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class SeasonAdapter:BaseListAdapter<SeasonItemUiState>(SeasonItemUiStateDiffUtil()) {
    override val layoutId: Int = R.layout.item_season
}

class SeasonItemUiStateDiffUtil : DiffUtil.ItemCallback<SeasonItemUiState>() {
    override fun areItemsTheSame(oldItem: SeasonItemUiState, newItem: SeasonItemUiState): Boolean =
         oldItem.season == newItem.season

    override fun areContentsTheSame(
        oldItem: SeasonItemUiState,
        newItem: SeasonItemUiState
    ): Boolean =oldItem == newItem
}
