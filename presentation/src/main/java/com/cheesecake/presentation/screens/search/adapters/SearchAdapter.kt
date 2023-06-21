package com.cheesecake.presentation.screens.search.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.presentation.databinding.ItemSearchLeagueBinding
import com.cheesecake.presentation.databinding.ItemSearchTeamBinding
import androidx.databinding.library.baseAdapters.BR
import com.cheesecake.presentation.screens.search.models.SearchResult


class SearchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var itemList = emptyList<SearchResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_LEAGUE -> LeagueViewHolder(
                ItemSearchLeagueBinding.inflate(
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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LeagueViewHolder -> holder.bind(itemList[position] as SearchResult.League)
            is TeamViewHolder -> holder.bind(itemList[position] as SearchResult.Team)
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is SearchResult.Team -> TYPE_TEAM
            is SearchResult.League -> TYPE_LEAGUE
            else -> throw IllegalArgumentException("invalid")

        }
    }

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class LeagueViewHolder(private val binding: ItemSearchLeagueBinding) : BaseViewHolder(binding) {
        fun bind(league: SearchResult.League) {
            binding.setVariable(BR.item, league)
            binding.recyclerViewSearchLeagues.adapter = SearchLeagueAdapter()
        }
    }

    class TeamViewHolder(private val binding: ItemSearchTeamBinding) : BaseViewHolder(binding) {
        fun bind(team: SearchResult.Team) {
            binding.setVariable(BR.item, team)
            binding.recyclerViewSearchLeagues.adapter = SearchTeamAdapter()
        }
    }

    fun setItems(newItems: List<SearchResult>) {
        val diffResult =
            DiffUtil.calculateDiff(SearchDiffUtil(itemList, newItems, ::areItemsSame, ::areContentSame))
        itemList = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    private fun areItemsSame(oldItem: SearchResult, newItem: SearchResult) = oldItem == newItem
    private fun areContentSame(oldPosition: SearchResult, newPosition: SearchResult) = true

    companion object {
        const val TYPE_LEAGUE = 0
        const val TYPE_TEAM = 1
        const val TYPE_PLAYER = 2
    }
}




