package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.SquadDTO
import com.cheesecake.domain.entity.SquadPlayer

@JvmName("squadDTOsToSquadPlayers")
fun List<SquadDTO>.toEntity(): List<SquadPlayer> =
    this.flatMap { it.players.map { player -> player.toEntity() } }

@JvmName("squadDTOToSquadPlayer")
fun SquadDTO.Player.toEntity(): SquadPlayer = SquadPlayer(id, name, age, number ?: -1, position, photo)
