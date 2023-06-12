package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.PlayerDTO
import com.cheesecake.domain.entity.TeamPlayers

@JvmName("PlayerDTOToPlayer")
fun PlayerDTO.toDomainEntity(): TeamPlayers {
    return TeamPlayers(
        name = this.player.name,
        country = this.player.birth.country,
        position = this.statistics.first().games.position,
        photo=this.player.photo

    )
}
@JvmName("PlayerDTOsToPlayers")
fun List<PlayerDTO>.toDomainEntity():List<TeamPlayers>{
    return this.map { it.toDomainEntity() }
}