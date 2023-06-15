package com.cheesecake.presentation.screens.discover

import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter

class DiscoverCountryAdapter:BaseAdapter<TeamCountry>(null) {
    override val layoutId: Int
        get() = R.layout.item_country_team
}