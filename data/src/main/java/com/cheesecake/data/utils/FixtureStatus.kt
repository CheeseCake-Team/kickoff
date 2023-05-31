package com.cheesecake.data.utils

enum class FixtureStatus {
    TimeToBeDefined,
    NotStarted,
    FirstHalf,
    SecondHalf,
    ExtraTime,
    BreakTime,
    PenaltyInProgress,
    MatchSuspended,
    MatchInterrupted,
    MatchFinished,
    MatchFinishedAfterExtraTime,
    MatchFinishedAfterPenalty,
    MatchPostponed,
    MatchCancelled,
    MatchAbandoned,
    TechnicalLoss,
    WalkOver,
    InProgress;

    override fun toString(): String {
        return when (this) {
            TimeToBeDefined -> "TBD"
            NotStarted -> "NS"
            FirstHalf -> "1H"
            SecondHalf -> "2H"
            ExtraTime -> "ET"
            BreakTime -> "BT"
            PenaltyInProgress -> "P"
            MatchSuspended -> "SUSP"
            MatchInterrupted -> "INT"
            MatchFinished -> "FT"
            MatchFinishedAfterExtraTime -> "AET"
            MatchFinishedAfterPenalty -> "PEN"
            MatchPostponed -> "PST"
            MatchCancelled -> "CANC"
            MatchAbandoned -> "ABD"
            TechnicalLoss -> "AWD"
            WalkOver -> "WO"
            InProgress -> "LIVE"

        }
    }
}
