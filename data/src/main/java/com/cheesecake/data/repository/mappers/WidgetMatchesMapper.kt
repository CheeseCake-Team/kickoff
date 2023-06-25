package com.cheesecake.data.repository.mappers

import com.cheesecake.data.remote.models.FixtureDTO
import com.cheesecake.domain.entity.WidgetMatch

@JvmName("FixtureToDomain")
fun FixtureDTO.toWidget(): WidgetMatch{
    return WidgetMatch(
        this.fixtureDataDTO.id,
        this.teams.home.name,
        this.teams.home.logo,
        this.teams.away.name,
        this.teams.away.logo,
    )
}

@JvmName("FixtureToDomainList")
fun List<FixtureDTO>.toWidget(): List<WidgetMatch>{
    return this.map {
        it.toWidget()
    }
}