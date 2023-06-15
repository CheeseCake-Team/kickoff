package com.cheesecake.presentation.screens.favoriteTeams

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class FavoriteTeamsAdapter: BaseListAdapter<FavoriteTeamItemUiState>(FavoriteTeamItemUiStateDiffUtil()) {
    override val layoutId = R.layout.item_favorite_team
}

class FavoriteTeamItemUiStateDiffUtil: DiffUtil.ItemCallback<FavoriteTeamItemUiState>() {
    override fun areItemsTheSame(
        oldItem: FavoriteTeamItemUiState,
        newItem: FavoriteTeamItemUiState
    ): Boolean = oldItem.teamId == newItem.teamId

    override fun areContentsTheSame(
        oldItem: FavoriteTeamItemUiState,
        newItem: FavoriteTeamItemUiState
    ): Boolean = oldItem == newItem

}