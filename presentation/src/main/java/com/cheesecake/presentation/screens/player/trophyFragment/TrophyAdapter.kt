package com.cheesecake.presentation.screens.player.trophyFragment

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.domain.entity.Trophy
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseListAdapter

class TrophyAdapter : BaseListAdapter<Trophy>(TrophyDiffUtil()) {

    override val layoutId: Int
        get() = R.layout.item_trophy
}

class TrophyDiffUtil : DiffUtil.ItemCallback<Trophy>() {
    override fun areItemsTheSame(oldItem: Trophy, newItem: Trophy): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Trophy, newItem: Trophy): Boolean {
        return true
    }
}