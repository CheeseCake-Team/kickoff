package com.cheesecake.presentation.screens.search.adapters

import androidx.recyclerview.widget.DiffUtil
import com.cheesecake.presentation.screens.search.models.SearchResult

open class SearchDiffUtil(
    private val oldList: List<SearchResult>,
    private val newList: List<SearchResult>,
    private val checkIfSameItem: (oldItem: SearchResult, newItem: SearchResult) -> Boolean,
    private val checkIfSameContent: (oldItem: SearchResult, newItem: SearchResult) -> Boolean
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIfSameItem(oldList[oldItemPosition], newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return checkIfSameContent(oldList[oldItemPosition], newList[newItemPosition])
    }
}