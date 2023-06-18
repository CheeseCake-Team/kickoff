package com.cheesecake.presentation.screens.discover

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.models.TeamCountryUIState

class DiscoverCountryAdapter:BaseListAdapter<TeamCountryUIState>(TeamCountryUIStateDiffUtil()) {
    override val layoutId = R.layout.item_country_team
}

class TeamCountryUIStateDiffUtil: DiffUtil.ItemCallback<TeamCountryUIState>() {
    override fun areItemsTheSame(oldItem: TeamCountryUIState, newItem: TeamCountryUIState): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: TeamCountryUIState, newItem: TeamCountryUIState): Boolean =
        oldItem == newItem

}