package com.cheesecake.presentation.screens.timezone

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class SeasonAdapter: BaseListAdapter<TimezoneItemUiState>(TimezoneItemUiStateDiffUtil()) {
    override val layoutId: Int = R.layout.item_timezone
}

class TimezoneItemUiStateDiffUtil : DiffUtil.ItemCallback<TimezoneItemUiState>() {
    override fun areItemsTheSame(oldItem: TimezoneItemUiState, newItem: TimezoneItemUiState): Boolean =
        oldItem.timezone == newItem.timezone

    override fun areContentsTheSame(
        oldItem: TimezoneItemUiState,
        newItem: TimezoneItemUiState
    ): Boolean =oldItem == newItem
}