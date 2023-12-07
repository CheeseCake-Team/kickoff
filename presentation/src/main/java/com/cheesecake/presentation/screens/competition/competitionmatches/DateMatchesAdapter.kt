package com.cheesecake.presentation.screens.competition.competitionmatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class DateMatchesAdapter: BaseListAdapter<DateMatchesItemUiState>(DateMatchesItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_date_matches
}

class DateMatchesItemUIStateDiffUtil: DiffUtil.ItemCallback<DateMatchesItemUiState>() {
    override fun areItemsTheSame(
        oldItem: DateMatchesItemUiState,
        newItem: DateMatchesItemUiState
    ): Boolean = oldItem.date == newItem.date

    override fun areContentsTheSame(
        oldItem: DateMatchesItemUiState,
        newItem: DateMatchesItemUiState
    ): Boolean = oldItem == newItem
}