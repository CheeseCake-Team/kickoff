package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.response.PlayerResponse
import com.cheesecake.domain.entity.PlayerStatisticsEntity

fun PlayerResponse.mapToDomain(): PlayerStatisticsEntity {
    return PlayerStatisticsEntity(
        id = this.player.id,
        name = this.player.name,
        firstname = this.player.firstname,
        lastname = this.player.lastname,
        age = this.player.age,
        date = this.player.birth.date,
        place = this.player.birth.place,
        country = this.player.birth.country,
        nationality = this.player.nationality,
        height = this.player.height,
        weight = this.player.weight,
        injured = this.player.injured,
        appearences = this.statistics.first().games.appearences,
        lineups = this.statistics.first().games.lineups,
        minutes = this.statistics.first().games.minutes,
        number = this.statistics.first().games.number,
        position = this.statistics.first().games.position,
        rating = this.statistics.first().games.rating,
        captain = this.statistics.first().games.captain,
        photo = this.player.photo
    )
}

fun List<PlayerResponse>.mapToDomain():List<PlayerStatisticsEntity>{
    return this.map { it.mapToDomain() }
}