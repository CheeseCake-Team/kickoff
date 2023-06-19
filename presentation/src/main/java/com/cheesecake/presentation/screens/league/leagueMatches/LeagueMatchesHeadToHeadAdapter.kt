package com.cheesecake.presentation.screens.league.leagueMatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class LeagueMatchesHeadToHeadAdapter : BaseListAdapter<Fixture>(FixtureDiffUtils()) {
    override val layoutId = R.layout.item_head_to_head
}

class FixtureDiffUtils : DiffUtil.ItemCallback<Fixture>() {
    override fun areItemsTheSame(oldItem: Fixture, newItem: Fixture): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Fixture, newItem: Fixture): Boolean =
        oldItem == newItem

}