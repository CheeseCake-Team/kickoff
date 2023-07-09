package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import com.cheesecake.data.remote.models.TeamCountriesDTO
import com.cheesecake.domain.entity.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@JvmName("teamCountryDTOToTeamCountry")
fun TeamCountriesDTO.toEntity(): Country =
    Country(
        name = name,
        flag = flag ?: ""
    )

fun TeamCountriesLocalDTO.toEntity(): Country =
    Country(
        name = name,
        flag = flagImageUrl
    )

@JvmName("teamCountryToTeamCountryLocalDTO")
fun Country.toLocal(): TeamCountriesLocalDTO = TeamCountriesLocalDTO(
    name = name,
    flagImageUrl = flag
)

@JvmName("listOfTeamCountryDTOToListOfTeamCountryLocalDTO")
fun List<Country>.toLocal(): List<TeamCountriesLocalDTO> = map { it.toLocal() }

@JvmName("listOfTeamCountryDTOToListOfTeamCountry")
fun List<TeamCountriesDTO>.toEntity(): List<Country> = map { it.toEntity() }

@JvmName("listOfTeamCountryLocalDTOToListOfTeamCountry")
fun List<TeamCountriesLocalDTO>.toEntity(): List<Country> = map { it.toEntity() }


@JvmName("flowListOfTeamCountryLocalDTOToFlowListOfTeamCountry")
fun Flow<List<TeamCountriesLocalDTO>>.toEntity(): Flow<List<Country>> = map { it.toEntity() }

