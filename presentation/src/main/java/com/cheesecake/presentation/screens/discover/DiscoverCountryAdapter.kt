package com.cheesecake.presentation.screens.discover

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.models.CountryItemUIState

class DiscoverCountryAdapter:BaseListAdapter<CountryItemUIState>(TeamCountryUIStateDiffUtil()) {
    override val layoutId = R.layout.item_country
}

class TeamCountryUIStateDiffUtil: DiffUtil.ItemCallback<CountryItemUIState>() {
    override fun areItemsTheSame(oldItem: CountryItemUIState, newItem: CountryItemUIState): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: CountryItemUIState, newItem: CountryItemUIState): Boolean =
        oldItem == newItem

}