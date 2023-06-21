package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.presentation.screens.search.adapters.SearchDiffUtil
import com.cheesecake.presentation.screens.search.adapters.SearchLeagueAdapter
import com.cheesecake.presentation.screens.search.adapters.SearchTeamAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.presentation.databinding.ItemSearchLeagueBinding
import com.cheesecake.presentation.databinding.ItemSearchTeamBinding
import androidx.databinding.library.baseAdapters.BR
import com.cheesecake.presentation.screens.search.models.SearchResult


class HomeSearchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList = emptyList<SearchResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LeagueViewHolder(
            ItemSearchLeagueBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LeagueViewHolder -> holder.bind(itemList[position] as SearchResult.League)
        }
    }

    override fun getItemCount(): Int = itemList.size

//    override fun getItemViewType(position: Int): Int {
//        return when (itemList[position]) {
//            is SearchResult.Team -> TYPE_RECENT
//            is SearchResult.League -> TYPE_PLAYER
//            else -> throw IllegalArgumentException("invalid")
//
//        }
//    }

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class LeagueViewHolder(private val binding: ItemSearchLeagueBinding) : BaseViewHolder(binding) {
        fun bind(league: SearchResult.League) {
            binding.setVariable(BR.item, league)
            binding.recyclerViewSearchLeagues.adapter = SearchLeagueAdapter()
        }
    }

    fun setItems(newItems: List<SearchResult>) {
        val diffResult =
            DiffUtil.calculateDiff(
                SearchDiffUtil(
                    itemList,
                    newItems,
                    ::areItemsSame,
                    ::areContentSame
                )
            )
        itemList = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    private fun areItemsSame(oldItem: SearchResult, newItem: SearchResult) = oldItem == newItem
    private fun areContentSame(oldPosition: SearchResult, newPosition: SearchResult) = true

    companion object {
        const val TYPE_RECENT = 0
        const val TYPE_PLAYER = 1
    }
}




