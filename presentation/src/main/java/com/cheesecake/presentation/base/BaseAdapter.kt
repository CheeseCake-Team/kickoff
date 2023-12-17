package com.cheesecake.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cheesecake.presentation.R
import com.cheesecake.presentation.databinding.ItemDateMatchesBinding
import com.cheesecake.presentation.databinding.ItemMatchTeamLineupBinding
import com.cheesecake.presentation.screens.competition.competitionmatches.CompetitionMatchesHeadToHeadAdapter
import com.cheesecake.presentation.screens.match.lineup.ItemMatchPlayersAdapter


interface BaseInteractionListener

abstract class BaseAdapter<T>(private val listener: BaseInteractionListener?) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    var itemList = emptyList<T>()
    abstract val layoutId: Int

    open fun setItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(
            BaseDiffUtil(
                itemList, newItems, ::areItemsSame, ::areContentSame
            )
        )
        itemList = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = itemList.size

    open fun areItemsSame(oldItem: T, newItem: T) = oldItem?.equals(newItem) == true
    open fun areContentSame(oldPosition: T, newPosition: T) = true


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemList[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.apply {
                    setVariable(BR.item, currentItem)

                    when (this) {
                        is ItemDateMatchesBinding -> {
                            headToHeadRecyclerView.adapter = CompetitionMatchesHeadToHeadAdapter()
                            ContextCompat.getColor(this.root.context, R.color.fontHeavy)
                        }

                        is ItemMatchTeamLineupBinding -> {
                            recyclerViewStarterPlayers.adapter = ItemMatchPlayersAdapter()
                            recyclerViewSubstitutesPlayers.adapter = ItemMatchPlayersAdapter()
                        }
                    }
                }
            }
        }
    }
    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}
