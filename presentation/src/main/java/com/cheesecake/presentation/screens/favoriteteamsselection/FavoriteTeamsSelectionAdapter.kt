package com.cheesecake.presentation.screens.favoriteteamsselection

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class FavoriteTeamsSelectionAdapter :
    BaseListAdapter<SelectedTeamItemUiState>(FavoriteTeamsItemUiStateDiffUtil()) {
    override val layoutId = R.layout.item_favorite_team_selection
}

class FavoriteTeamsItemUiStateDiffUtil : DiffUtil.ItemCallback<SelectedTeamItemUiState>() {
    override fun areItemsTheSame(
        oldItem: SelectedTeamItemUiState,
        newItem: SelectedTeamItemUiState
    ): Boolean {
        return oldItem.teamId == newItem.teamId
    }

    override fun areContentsTheSame(
        oldItem: SelectedTeamItemUiState,
        newItem: SelectedTeamItemUiState
    ): Boolean {
        return oldItem == newItem
    }
}