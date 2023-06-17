package com.cheesecake.presentation.screens.teamMatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamMatchesDateAdapter: BaseListAdapter<Pair<String, List<Fixture>>>(
DateMatchesDiffUtil(),
null
) {
    override val layoutId = R.layout.item_team_date_matches
}

class DateMatchesDiffUtil() : DiffUtil.ItemCallback<Pair<String, List<Fixture>>>() {

    override fun areItemsTheSame(
        oldItem: Pair<String, List<Fixture>>,
        newItem: Pair<String, List<Fixture>>
    ): Boolean = oldItem.first == newItem.first

    override fun areContentsTheSame(
        oldItem: Pair<String, List<Fixture>>,
        newItem: Pair<String, List<Fixture>>
    ): Boolean = oldItem.second == newItem.second
}
