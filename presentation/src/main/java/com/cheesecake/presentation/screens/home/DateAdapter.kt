package com.cheesecake.presentation.screens.home

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class DateAdapter: BaseListAdapter<DateItemUIState>(DateItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_home_date

}

class DateItemUIStateDiffUtil: DiffUtil.ItemCallback<DateItemUIState>() {

    override fun areItemsTheSame(oldItem: DateItemUIState, newItem: DateItemUIState): Boolean =
        oldItem.day == newItem.day

    override fun areContentsTheSame(oldItem: DateItemUIState, newItem: DateItemUIState): Boolean =
        oldItem == newItem

}