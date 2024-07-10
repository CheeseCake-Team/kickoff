package com.cheesecake.presentation.screens.favoritecompetitionsselection

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class FavoriteCompetitionsSelectionAdapter :
    BaseListAdapter<SelectedCompetitionItemUiState>(FavoriteCompetitionsSelectionItemUiStateDiffUtil()) {
    override val layoutId = R.layout.item_favorite_competition_selection
}

class FavoriteCompetitionsSelectionItemUiStateDiffUtil :
    DiffUtil.ItemCallback<SelectedCompetitionItemUiState>() {
    override fun areItemsTheSame(
        oldItem: SelectedCompetitionItemUiState,
        newItem: SelectedCompetitionItemUiState
    ): Boolean {
        return oldItem.competitionId == newItem.competitionId
    }

    override fun areContentsTheSame(
        oldItem: SelectedCompetitionItemUiState,
        newItem: SelectedCompetitionItemUiState
    ): Boolean {
        return oldItem == newItem
    }
}