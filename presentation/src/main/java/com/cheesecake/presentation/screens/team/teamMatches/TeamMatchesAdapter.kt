package com.cheesecake.presentation.screens.team.teamMatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamMatchesAdapter: BaseListAdapter<List<Fixture>>(
    DateMatchesDiffUtil()
) {
    override val layoutId = R.layout.item_team_match
}

class DateMatchesDiffUtil : DiffUtil.ItemCallback<List<Fixture>>() {
    override fun areItemsTheSame(
        oldItem: List<Fixture>,
        newItem: List<Fixture>
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: List<Fixture>,
        newItem: List<Fixture>
    ): Boolean = oldItem == newItem
}