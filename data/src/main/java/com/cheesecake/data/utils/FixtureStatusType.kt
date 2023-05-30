package com.cheesecake.data.utils

enum class FixtureStatusType {
    SCHEDULED,
    IN_PLAY,
    FINISHED,
    POSTPONED,
    CANCELLED,
    ABANDONED,
    NOT_PLAYED;

    override fun toString(): String {
        return when (this) {
            SCHEDULED -> "Scheduled"
            IN_PLAY -> "In Play"
            FINISHED -> "Finished"
            POSTPONED -> "Postponed"
            CANCELLED -> "Cancelled"
            ABANDONED -> "Abandoned"
            NOT_PLAYED -> "Not Played"
        }
    }
}
