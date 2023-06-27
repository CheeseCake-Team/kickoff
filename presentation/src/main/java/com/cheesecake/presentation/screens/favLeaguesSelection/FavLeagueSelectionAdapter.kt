package com.cheesecake.presentation.screens.favLeaguesSelection

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class FavLeagueSelectionAdapter : BaseListAdapter<FavLeagueItemUIState>(FavLeagueItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_select_fav_league
}

class FavLeagueItemUIStateDiffUtil: DiffUtil.ItemCallback<FavLeagueItemUIState>(){
    override fun areItemsTheSame(
        oldItem: FavLeagueItemUIState,
        newItem: FavLeagueItemUIState
    ): Boolean {
         return oldItem.leagueId == newItem.leagueId
    }

    override fun areContentsTheSame(
        oldItem: FavLeagueItemUIState,
        newItem: FavLeagueItemUIState
    ): Boolean {
       return oldItem == newItem
    }

}