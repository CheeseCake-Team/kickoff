package com.cheesecake.ui.utils

import com.cheesecake.domain.models.Team
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseAdapter

class TeamsAdapter: BaseAdapter<Team>(null) {
    override val layoutId: Int
        get() = R.layout.item_team
}