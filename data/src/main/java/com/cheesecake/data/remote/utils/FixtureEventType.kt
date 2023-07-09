package com.cheesecake.data.remote.utils

enum class FixtureEventType {
    GOAL, CARD, SUBST, VAR;

    override fun toString(): String {
        return when (this) {
            GOAL -> "Goal"
            CARD -> "Card"
            SUBST -> "Subst"
            VAR -> "Var"
        }
    }
}