package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.LineupDTO
import com.cheesecake.data.remote.models.PlayerPosGridDTO
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.PlayerLineup

@JvmName("LineupDTOToFixtureLineup")
fun LineupDTO.toEntity(): FixtureLineup {
    return FixtureLineup(
        teamId = this.team.id,
        coachId = this.coach.id,
        coachName = this.coach.name,
        coachImageUrl = this.coach.photo,
        formation = this.formation,
        playerLineup = this.startXI.toEntity()

    )
}
@JvmName("LineupDTOsToFixtureLineups")
fun List<LineupDTO>.toEntity(): List<FixtureLineup> {
    return map { it.toEntity() }
}

fun List<LineupDTO.StartXI>.toEntity(): List<PlayerLineup> {
return map {  it.player.toEntity() }
}

fun PlayerPosGridDTO.toEntity(): PlayerLineup{
    return PlayerLineup(
        playerId = this.id,
        playerName = this.name,
        playerNumber = this.number,
        playerPosition = this.pos,
        playerPositionGrid = this.grid
    )
}
