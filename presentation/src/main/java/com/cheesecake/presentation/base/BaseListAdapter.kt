package com.cheesecake.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.presentation.databinding.ItemDateMatchesBinding
import com.cheesecake.presentation.databinding.ItemLeagueFollowedWithMatchesBinding
import com.cheesecake.presentation.screens.home.MatchesAdapter
import com.cheesecake.presentation.screens.competition.competitionmatches.CompetitionMatchesHeadToHeadAdapter
import androidx.databinding.library.baseAdapters.BR
import com.cheesecake.presentation.databinding.ItemStandingBinding
import com.cheesecake.presentation.databinding.ItemStatisticsBlockBinding
import com.cheesecake.presentation.databinding.ItemTeamPlayersPositionsBinding
import com.cheesecake.presentation.screens.player.playerStatistics.SectionItemAdapter
import com.cheesecake.presentation.screens.standings.StandingFormAdapter
import com.cheesecake.presentation.screens.team.teamPlayers.TeamPlayersAdapter

abstract class BaseListAdapter<T>(
    diffutils: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, BaseListAdapter.BaseViewHolder<T>>(diffutils) {

    abstract val layoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return BaseViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    open class BaseViewHolder<T>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: T) {
            binding.setVariable(BR.item, currentItem)

            when(binding) {
                is ItemDateMatchesBinding -> {
                    binding.headToHeadRecyclerView.adapter = CompetitionMatchesHeadToHeadAdapter()
                }
                is ItemLeagueFollowedWithMatchesBinding -> {
                    binding.matchesRecyclerView.adapter = MatchesAdapter()
                }
                is ItemTeamPlayersPositionsBinding -> {
                    binding.playersPositionRecycler.adapter = TeamPlayersAdapter()
                }
                is ItemStatisticsBlockBinding -> {
                    binding.recyclerBlock.adapter = SectionItemAdapter()
                }
                is ItemStandingBinding -> {
                    binding.formRecyclerView.adapter = StandingFormAdapter()
                }
            }

        }
    }
}