package com.cheesecake.presentation.screens.league.leagueMatches

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.databinding.ItemDateMatchesBinding

class LeagueMatchesDateMatchAdapter : BaseAdapter<ItemDateMatchesBinding>(null) {
    override val layoutId = R.layout.item_date_matches
}

//class DateMatchesDiffUtil : DiffUtil.ItemCallback<ItemDateMatchesBinding>() {
//
//    override fun areItemsTheSame(
//        oldItem: ItemDateMatchesBinding,
//        newItem: ItemDateMatchesBinding>
//    ): Boolean = oldItem.first == newItem.first
//
//    override fun areContentsTheSame(
//        oldItem: ItemDateMatchesBinding,
//        newItem: ItemDateMatchesBinding
//    ): Boolean = oldItem.second == newItem.second
//
//}