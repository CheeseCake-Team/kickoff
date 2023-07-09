package com.cheesecake.presentation.screens.home

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.base.BaseListAdapter

class MatchesAdapter: BaseAdapter<MatchItemUIState>(null){
    override val layoutId = R.layout.item_match
}
