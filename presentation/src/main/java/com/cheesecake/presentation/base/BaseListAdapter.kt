package com.cheesecake.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.presentation.databinding.ItemDateMatchesBinding
import com.cheesecake.presentation.screens.leagueMatches.LeagueMatchesHeadToHeadAdapter

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
            binding.setVariable(androidx.databinding.library.baseAdapters.BR.item, currentItem)

            when(binding) {
                is ItemDateMatchesBinding -> {
                    binding.headToHeadRecyclerView.adapter = LeagueMatchesHeadToHeadAdapter()
                }
            }

        }
    }
}