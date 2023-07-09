package com.cheesecake.presentation.screens.team.teamstatistics

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TeamStatisticsFormAdapter : BaseListAdapter<String>(FormItemDiffUtil()) {
    override val layoutId = R.layout.item_team_form
}

class FormItemDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
}