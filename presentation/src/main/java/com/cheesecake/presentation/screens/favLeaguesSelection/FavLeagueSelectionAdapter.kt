package com.cheesecake.presentation.screens.favLeaguesSelection

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.base.BaseListAdapter
import com.cheesecake.presentation.databinding.ItemSelectFavBinding

class FavLeagueSelectionAdapter : BaseListAdapter<FavLeagueItemUIState>(FavLeagueItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_select_fav
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