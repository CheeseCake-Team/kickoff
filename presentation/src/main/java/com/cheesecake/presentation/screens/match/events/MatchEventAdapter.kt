package com.cheesecake.presentation.screens.match.events

import android.view.View
import androidx.core.view.isVisible
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.databinding.ItemMatchEventBinding

class MatchEventAdapter(val matchId: String = "33-34") : BaseAdapter<ItemEventUIState>(null) {
    override val layoutId = R.layout.item_match_event

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemss[position]
        if (holder is ItemViewHolder) {
            with(holder.binding) {
                setVariable(androidx.databinding.library.baseAdapters.BR.item, currentItem)

                this as ItemMatchEventBinding
                when {
                    currentItem.longType == "Normal Goal" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_football)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE


                    }

                    currentItem.longType == "Own Goal" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_bell)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    currentItem.longType == "Penalty" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_bell)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    currentItem.longType == "Missed Penalty" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_bell)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    currentItem.longType == "Yellow Card" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_yellowcard)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    currentItem.longType == "Red Card" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_redcard)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    currentItem.shortType == "subst" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_substitution)
                        textViewHomeTeamSubstituentPlayerName.isVisible = true
                        textViewAwayTeamSubstituentPlayerName.isVisible = true

                    }

                    currentItem.longType == "Goal cancelled" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_bell)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    currentItem.longType == "Penalty confirmed" -> {
                        imageViewEventType.setImageResource(R.drawable.ic_bell)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }
                }

                val teamIds = matchId.split("-")
                when (currentItem.teamId) {
                    teamIds[0].toInt() -> {
                        cardViewHomeTeamEvent.isVisible = true
                        cardViewAwayTeamEvent.visibility = View.GONE
                    }
                    teamIds[1].toInt() -> {
                        cardViewHomeTeamEvent.visibility = View.GONE
                        cardViewAwayTeamEvent.isVisible = true
                    }
                }
            }


        }


    }


}