package com.cheesecake.presentation.screens.standings

import  com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.domain.entity.TeamStanding
import com.cheesecake.presentation.R

class StandingsAdapter:BaseAdapter<TeamStanding>(null)  {
    override val layoutId = R.layout.item_standing

}