package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import com.cheesecake.data.remote.models.TeamCountriesDTO
import com.cheesecake.domain.entity.TeamCountry

@JvmName("teamCountryDTOToTeamCountry")
fun TeamCountriesDTO.toEntity(): TeamCountry =
    TeamCountry(
        name = name,
        flag = flag ?: ""
    )

fun TeamCountriesLocalDTO.toEntity(): TeamCountry =
    TeamCountry(
        name = name,
        flag = flagImageUrl
    )

@JvmName("teamCountryToTeamCountryLocalDTO")
fun TeamCountry.toLocal(): TeamCountriesLocalDTO = TeamCountriesLocalDTO(
    name = name,
    flagImageUrl = flag
)

@JvmName("listOfTeamCountryDTOToListOfTeamCountryLocalDTO")
fun List<TeamCountry>.toLocal(): List<TeamCountriesLocalDTO> = map { it.toLocal() }

@JvmName("listOfTeamCountryDTOToListOfTeamCountry")
fun List<TeamCountriesDTO>.toEntity(): List<TeamCountry> = map { it.toEntity() }

@JvmName("listOfTeamCountryLocalDTOToListOfTeamCountry")
fun List<TeamCountriesLocalDTO>.toEntity(): List<TeamCountry> = map { it.toEntity() }

