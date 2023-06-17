package com.cheesecake.presentation.screens.favLeaguesSelection

import androidx.core.content.ContextCompat
import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.databinding.ItemSelectFavBinding

class FavLeagueSelectionAdapter : BaseAdapter<League>(null) {
    override val layoutId = R.layout.item_select_fav

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemss[position]
        if(holder is ItemViewHolder){
            with(holder.binding){
                this as ItemSelectFavBinding
                setVariable(androidx.databinding.library.baseAdapters.BR.item, currentItem)

                if (currentItem.isSelected) {
                    shapeableImageView.foreground = ContextCompat.getDrawable(root.context, R.drawable.selected_fav_item)
                } else {
                    shapeableImageView.foreground = null
                }
            }
        }
    }
}