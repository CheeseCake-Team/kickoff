package com.cheesecake.presentation.screens.league.leagueMatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class DateMatchesAdapter: BaseListAdapter<DateMatchesItemUIState>(DateMatchesItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_date_matches
}

class DateMatchesItemUIStateDiffUtil: DiffUtil.ItemCallback<DateMatchesItemUIState>() {
    override fun areItemsTheSame(
        oldItem: DateMatchesItemUIState,
        newItem: DateMatchesItemUIState
    ): Boolean = oldItem.date == newItem.date

    override fun areContentsTheSame(
        oldItem: DateMatchesItemUIState,
        newItem: DateMatchesItemUIState
    ): Boolean = oldItem == newItem

}