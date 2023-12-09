package com.cheesecake.presentation.screens.home

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class DateAdapter: BaseListAdapter<DateItemUiState>(DateItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_home_date
}

class DateItemUIStateDiffUtil: DiffUtil.ItemCallback<DateItemUiState>() {
    override fun areItemsTheSame(oldItem: DateItemUiState, newItem: DateItemUiState): Boolean =
        oldItem.day == newItem.day

    override fun areContentsTheSame(oldItem: DateItemUiState, newItem: DateItemUiState): Boolean =
        oldItem == newItem
}