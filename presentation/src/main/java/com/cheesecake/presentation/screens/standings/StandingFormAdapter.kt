package com.cheesecake.presentation.screens.standings

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class StandingFormAdapter: BaseListAdapter<String>(FormItemDiffUtil()) {
    override val layoutId = R.layout.item_standing_form
}

class FormItemDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
}