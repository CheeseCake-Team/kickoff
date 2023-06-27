package com.cheesecake.presentation.screens.favTeamsSelection

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class FavTeamsSelectionAdapter : BaseListAdapter< FavTeamItemUIState>(FavLeagueItemUIStateDiffUtil()) {
    override val layoutId = R.layout.item_select_fav_team
}

class FavLeagueItemUIStateDiffUtil: DiffUtil.ItemCallback<FavTeamItemUIState>(){
    override fun areItemsTheSame(
        oldItem: FavTeamItemUIState,
        newItem: FavTeamItemUIState
    ): Boolean {
         return oldItem.teamId == newItem.teamId
    }

    override fun areContentsTheSame(
        oldItem: FavTeamItemUIState,
        newItem: FavTeamItemUIState
    ): Boolean {
       return oldItem == newItem
    }

}