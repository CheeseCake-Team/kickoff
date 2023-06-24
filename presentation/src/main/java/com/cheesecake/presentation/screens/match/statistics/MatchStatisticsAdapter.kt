package com.cheesecake.presentation.ui.match.statistics


import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.cheesecake.domain.entity.StatisticsType
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.databinding.ItemStatisticsBinding
import com.cheesecake.presentation.screens.match.statistics.StatisticsItemUiState

class MatchStatisticsAdapter : BaseAdapter<StatisticsItemUiState>(null) {
    override val layoutId = R.layout.item_statistics

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemList[position]
        if (holder is ItemViewHolder) {
            with(holder.binding) {
                setVariable(androidx.databinding.library.baseAdapters.BR.item, currentItem)

                val primaryColor = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        root.context,
                        R.color.primaryColor
                    )
                )
                val fontLight = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        root.context,
                        R.color.fontLight
                    )
                )
                this as ItemStatisticsBinding
                if (currentItem.statisticsType == StatisticsType.UNKNOWN) {
                    when {
                        currentItem.homeTeamPercentage == currentItem.awayTeamPercentage -> {
                            progressBarHomeTeam.progressTintList = primaryColor
                            progressBarAwayTeam.progressTintList = primaryColor
                        }

                        currentItem.homeTeamPercentage < currentItem.awayTeamPercentage -> {
                            progressBarHomeTeam.progressTintList = fontLight
                            progressBarAwayTeam.progressTintList = primaryColor
                        }

                        else -> {
                            progressBarHomeTeam.progressTintList = primaryColor
                            progressBarAwayTeam.progressTintList = fontLight
                        }
                    }
                } else {
                    when {
                        currentItem.homeTeamPercentage == currentItem.awayTeamPercentage -> {
                            progressBarHomeTeam.progressTintList = primaryColor
                            progressBarAwayTeam.progressTintList = primaryColor
                        }

                        currentItem.homeTeamPercentage < currentItem.awayTeamPercentage -> {
                            progressBarHomeTeam.progressTintList = primaryColor
                            progressBarAwayTeam.progressTintList = fontLight
                        }

                        else -> {
                            progressBarHomeTeam.progressTintList = fontLight
                            progressBarAwayTeam.progressTintList = primaryColor
                        }
                    }
                }
                val backgroundColors = listOf(R.color.tableLabel, R.color.transparent)
                val setPositionBackgroundColor = backgroundColors[position % backgroundColors.size]
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        holder.itemView.context,
                        setPositionBackgroundColor
                    )
                )
            }
        }
    }
}
