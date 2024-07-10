package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.PlayerDTO
import com.cheesecake.domain.entity.PlayerStatistics

@JvmName("playerDTOToPlayerStatistics")
fun PlayerDTO.toEntity(): PlayerStatistics {
    return PlayerStatistics(
        id = this.player.id,
        name = this.player.name,
        teamName = this.statistics.firstOrNull()?.team?.name ?: "NA",
        competitionCountry = this.statistics.firstOrNull()?.league?.country ?: "NA",
        firstname = this.player.firstname,
        lastname = this.player.lastname,
        age = this.player.age,
        birthDate = this.player.birth.date,
        birthPlace = this.player.birth.place,
        birthCountry = this.player.birth.country,
        nationality = this.player.nationality,
        heightInCm = this.player.height ?: "NA",
        weightInKg = this.player.weight ?: "NA",
        isInjured = this.player.injured,
        appearances = this.statistics.firstOrNull()?.games?.appearences ?: -1,
        lineups = this.statistics.firstOrNull()?.games?.lineups ?: -1,
        minutes = this.statistics.firstOrNull()?.games?.minutes ?: -1,
        number = this.statistics.firstOrNull()?.games?.number ?: -1,
        position = this.statistics.firstOrNull()?.games?.position ?: "NA",
        rating = this.statistics.firstOrNull()?.games?.rating ?: "NA",
        isCaptain = this.statistics.firstOrNull()?.games?.captain ?: false,
        imageUrl = this.player.photo,
        goals = this.statistics.firstOrNull()?.goals?.total ?: -1
    )
}

@JvmName("playerDTOsToPlayersStatistics")
fun List<PlayerDTO>.toEntity():List<PlayerStatistics>{
    return this.map { it.toEntity() }
}
