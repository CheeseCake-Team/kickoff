package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.EventDTO
import com.cheesecake.data.remote.models.FixtureDTO
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.FixtureEvents

@JvmName("EventDTOToFixtureEvent")
fun EventDTO.toEntity(): FixtureEvents {
    return FixtureEvents(
        time = this.time.elapsed,
        teamId = this.team.id,
        playerId = this.player.id,
        playerName = this.player.name,
        SubstituentPlayer = this.assist.name,
        type = this.detail,
        detail = this.comments
    )
}


@JvmName("EventDTOToFixtureEvent")
fun List<EventDTO>.toEntity(): List<FixtureEvents> {
    return this.map { it.toEntity() }
}