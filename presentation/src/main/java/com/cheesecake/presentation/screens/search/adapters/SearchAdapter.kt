package com.cheesecake.presentation.screens.search.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cheesecake.presentation.databinding.ItemSearchCompetitionBinding
import com.cheesecake.presentation.databinding.ItemSearchTeamBinding
import androidx.databinding.library.baseAdapters.BR
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.screens.search.models.SearchResult

class SearchAdapter : BaseAdapter<SearchResult>(null) {

    override val layoutId: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            TYPE_LEAGUE -> LeagueViewHolder(
                ItemSearchCompetitionBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            TYPE_TEAM -> TeamViewHolder(
                ItemSearchTeamBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is LeagueViewHolder -> holder.bind(itemList[position] as SearchResult.Competition)
            is TeamViewHolder -> holder.bind(itemList[position] as SearchResult.Team)
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is SearchResult.Team -> TYPE_TEAM
            is SearchResult.Competition -> TYPE_LEAGUE
        }
    }

    class LeagueViewHolder( val binding: ItemSearchCompetitionBinding) : BaseViewHolder(binding) {
        fun bind(competition: SearchResult.Competition) {
            binding.setVariable(BR.item, competition)
            binding.recyclerViewSearchLeagues.adapter = SearchLeagueAdapter()
        }
    }

    class TeamViewHolder( val binding: ItemSearchTeamBinding) : BaseViewHolder(binding) {
        fun bind(team: SearchResult.Team) {
            binding.setVariable(BR.item, team)
            binding.recyclerViewSearchLeagues.adapter = SearchTeamAdapter()
        }
    }

    companion object {
        const val TYPE_LEAGUE = 0
        const val TYPE_TEAM = 1
    }
}




