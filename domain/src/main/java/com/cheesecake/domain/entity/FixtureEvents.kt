package com.cheesecake.domain.entity

data class FixtureEvents(
    val time: Int?,
    val teamId: Int,
    val playerId: Int,
    val playerName: String,
    val substituentPlayerId: String?,
    val substituentPlayerName: String?,
    val eventType: EventType,
    val detail: String?
)

enum class EventType {
    NORMAL_GOAL, OWN_GOAL, PENALTY, MISSED_PENALTY, YELLOW_CARD, RED_CARD, SUBST, GOAL_CANCELLED, PENALTY_CONFIRMED;

    override fun toString(): String {
        return when (this) {
            NORMAL_GOAL -> "Normal Goal"
            OWN_GOAL -> "Own Goal"
            PENALTY -> "Penalty"
            MISSED_PENALTY -> "Missed Penalty"
            YELLOW_CARD -> "Yellow Card"
            RED_CARD -> "Red Card"
            SUBST -> "subst"
            GOAL_CANCELLED -> "Goal cancelled"
            PENALTY_CONFIRMED -> "Penalty confirmed"
        }
    }

}



