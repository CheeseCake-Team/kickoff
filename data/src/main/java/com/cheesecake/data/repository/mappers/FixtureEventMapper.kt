package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.EventDTO
import com.cheesecake.domain.entity.EventType
import com.cheesecake.domain.entity.FixtureEvents

@JvmName("EventDTOToFixtureEvent")
fun EventDTO.toEntity(): FixtureEvents {
    return FixtureEvents(
        time = this.time.elapsed,
        teamId = this.team.id,
        playerId = this.player.id,
        playerName = this.player.name,
        substituentPlayerId = this.assist.name,
        substituentPlayerName = this.assist.name,
        eventType = toEventType(this.type,this.detail),
        detail = this.comments
    )
}


@JvmName("EventDTOToFixtureEvent")
fun List<EventDTO>.toEntity(): List<FixtureEvents> {
    return this.map { it.toEntity() }
}

fun toEventType(type: String, detail: String): EventType {
    return when (type) {
        "Goal" -> {
            when (detail) {
                "Normal Goal" -> EventType.NORMAL_GOAL
                "Own Goal" -> EventType.OWN_GOAL
                "Penalty" -> EventType.PENALTY
                "Missed Penalty" -> EventType.MISSED_PENALTY
                else -> throw IllegalArgumentException("Invalid event title: $detail")
            }
        }
        "Card" -> {
            when (detail) {
                "Yellow Card" -> EventType.YELLOW_CARD
                "Red Card" -> EventType.RED_CARD
                else -> throw IllegalArgumentException("Invalid event title: $detail")
            }
        }

        "Var" -> {
            when (detail) {
                "Goal cancelled" -> EventType.GOAL_CANCELLED
                "Penalty confirmed" -> EventType.PENALTY_CONFIRMED
                "Penalty cancelled" -> EventType.PENALTY_CANCELLED
                else -> throw IllegalArgumentException("Invalid event title: $detail")
            }
        }
        else ->  EventType.SUBST
    }
}

