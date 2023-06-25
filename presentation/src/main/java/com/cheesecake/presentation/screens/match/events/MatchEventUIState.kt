package com.cheesecake.presentation.screens.match.events

import com.cheesecake.domain.entity.EventType
import com.cheesecake.domain.entity.FixtureEvents

data class MatchEventUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val data: List<ItemEventUIState> = emptyList()
)

data class ItemEventUIState(
    val time: Int? = 0,
    val teamId: Int= 0,
    val playerId: Int = 0,
    val playerName: String = "",
    val substituentPlayerId: String? = "",
    val substituentPlayerName: String?= "",
    val eventType: EventType ,
    val detail: String? = ""
)

fun List<FixtureEvents>.toUIState(): List<ItemEventUIState>{
    return map { ItemEventUIState(
        time = it.time,
        teamId = it.teamId,
        playerId = it.playerId,
        playerName = it.playerName,
        substituentPlayerId = it.substituentPlayerId,
        substituentPlayerName = it.substituentPlayerName,
        eventType = it.eventType,
        detail = it.detail
    ) }
}