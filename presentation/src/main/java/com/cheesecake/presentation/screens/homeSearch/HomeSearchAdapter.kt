package com.cheesecake.presentation.screens.homeSearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.databinding.ItemSearchRecentBinding

class HomeSearchAdapter : BaseAdapter<HomeSearchData>(null) {

    override val layoutId: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return RecentSearchViewHolder(
            ItemSearchRecentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is RecentSearchViewHolder -> holder.bind(itemList[position] as HomeSearchData.RecentSearches)
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

    class RecentSearchViewHolder(private val binding: ItemSearchRecentBinding) :
        BaseViewHolder(binding) {
        fun bind(recent: HomeSearchData.RecentSearches) {
            binding.setVariable(BR.item, recent)
            binding.recyclerViewRecentSearch.adapter = RecentSearchAdapter()
        }
    }

    companion object {
        const val TYPE_RECENT = 0
        const val TYPE_PLAYER = 1
    }
}




