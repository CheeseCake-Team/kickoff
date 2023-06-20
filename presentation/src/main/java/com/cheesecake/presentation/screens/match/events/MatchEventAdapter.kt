package com.cheesecake.presentation.screens.match.events

import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.cheesecake.domain.entity.EventType
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
                Log.e("TAG", "onSuccess:$currentItem ")

                Log.d("TAGGGG", "$currentItem")
                when (currentItem.eventType) {

                    EventType.PENALTY -> {
                        imageViewEventType.setImageResource(R.drawable.ic_penalty)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.MISSED_PENALTY -> {
                        imageViewEventType.setImageResource(R.drawable.ic_miss_penalty)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.YELLOW_CARD -> {
                        imageViewEventType.setImageResource(R.drawable.ic_yellowcard)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    EventType.RED_CARD -> {
                        imageViewEventType.setImageResource(R.drawable.ic_redcard)
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
                        imageViewEventType.setImageResource(R.drawable.ic_penaltyconfierm)
                        textViewHomeTeamSubstituentPlayerName.visibility = View.GONE
                        textViewAwayTeamSubstituentPlayerName.visibility = View.GONE

                    }

                    else -> {
                        imageViewEventType.setImageResource(R.drawable.ic_football)
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