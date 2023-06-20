package com.cheesecake.presentation.screens.match.events

import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.cheesecake.domain.entity.EventType
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseAdapter
import com.cheesecake.presentation.databinding.ItemMatchEventBinding

class MatchEventAdapter(val homeTeamId: Int = 33,val awayTeamId: Int = 34) : BaseAdapter<ItemEventUIState>(null) {
    override val layoutId = R.layout.item_match_event

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = itemss[position]
        if (holder is ItemViewHolder) {
            with(holder.binding) {
                setVariable(androidx.databinding.library.baseAdapters.BR.item, currentItem)

                this as ItemMatchEventBinding

                when (currentItem.eventType) {

                    EventType.PENALTY -> {
                        imageViewEventType.setImageResource(R.drawable.ic_penalty)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.MISSED_PENALTY -> {
                        imageViewEventType.setImageResource(R.drawable.ic_missed_penalty)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.YELLOW_CARD -> {
                        imageViewEventType.setImageResource(R.drawable.ic_yellow_card)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.RED_CARD -> {
                        imageViewEventType.setImageResource(R.drawable.ic_red_card)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.SUBST -> {
                        imageViewEventType.setImageResource(R.drawable.ic_substitution)
                        textViewHomeTeamSubstituentPlayerName.isVisible = true
                        textViewAwayTeamSubstituentPlayerName.isVisible = true

                    }

                    EventType.GOAL_CANCELLED -> {
                        imageViewEventType.setImageResource(R.drawable.ic_goal_cancelled)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.PENALTY_CONFIRMED -> {
                        imageViewEventType.setImageResource(R.drawable.ic_penalty_confirmed)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    else -> {
                        imageViewEventType.setImageResource(R.drawable.ic_football)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE
                    }
                }
                when (currentItem.teamId) {
                    homeTeamId -> {
                        cardViewHomeTeamEvent.isVisible = true
                        cardViewAwayTeamEvent.visibility = View.GONE
                    }

                    awayTeamId -> {
                        cardViewHomeTeamEvent.visibility = View.GONE
                        cardViewAwayTeamEvent.isVisible = true
                    }
                }
            }


        }


    }


}