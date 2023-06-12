package com.cheesecake.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.abaferastech.marvelapp.ui.base.BaseDiffUtil


interface BaseInteractionListener

abstract class BaseAdapter<T>(private val listener: BaseInteractionListener?) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    var itemss = emptyList<T>()
    abstract val layoutId: Int

    open fun setItems(newItems: List<T>) {
        val diffResult =
            DiffUtil.calculateDiff(BaseDiffUtil(itemss, newItems, ::areItemsSame, ::areContentSame))
        itemss = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    open fun areItemsSame(oldItem: T, newItem: T) = oldItem?.equals(newItem) == true
    open fun areContentSame(oldPosition: T, newPosition: T) = true


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemss[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.apply {
                    setVariable(androidx.databinding.library.baseAdapters.BR.item, currentItem)
                    setVariable(androidx.databinding.library.baseAdapters.BR.listener, listener)

                }
            }
        }
    }

    override fun getItemCount(): Int = itemss.size


    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

}
