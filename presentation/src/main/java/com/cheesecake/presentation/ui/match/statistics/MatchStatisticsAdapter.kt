package com.cheesecake.presentation.ui.match.statistics


import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.databinding.ItemStatisticsBinding
import java.lang.Integer.max

class MatchStatisticsAdapter : BaseAdapter<StatisticsItemUiState>(null) {
    override val layoutId = R.layout.item_statistics

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemss[position]
        if (holder is ItemViewHolder) {
            with(holder.binding) {
                setVariable(androidx.databinding.library.baseAdapters.BR.item, currentItem)

                val primaryColor = ColorStateList.valueOf(ContextCompat.getColor(root.context, R.color.primaryColor))
                this as ItemStatisticsBinding
                when {
                    currentItem.homeTeamPercentage >= currentItem.awayTeamPercentage -> {
                        progressBar2.progressTintList = primaryColor
                        if(currentItem.homeTeamPercentage == currentItem.awayTeamPercentage) progressBar3.progressTintList = primaryColor
                    }
                    else -> progressBar3.progressTintList = primaryColor
                }
            }
        }
    }
}