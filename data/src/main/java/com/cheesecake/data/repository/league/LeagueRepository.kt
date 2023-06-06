package com.cheesecake.data.repository.league

import com.cheesecake.data.local.LocalDataSource
import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.models.dto.LeagueDTO
import com.cheesecake.data.remote.RemoteDataSource
import com.cheesecake.data.utils.LeagueType
import javax.inject.Inject

class LeagueRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    ) {

    suspend fun getAllLeagues(): List<LeagueDTO> {
        return remoteDataSource.getAllLeagues()
    }

    suspend fun getLeaguesById(leagueId: Int): LeagueLocalDto {
        TODO("implement it..........")
    }

    suspend fun getLeaguesByName(leagueName: String): List<LeagueDTO> {
        return remoteDataSource.getLeaguesByName(leagueName)
    }

    suspend fun getLeaguesByCountryName(countryName: String): List<LeagueDTO> {
        return remoteDataSource.getLeaguesByCountryName(countryName)
    }

    suspend fun getLeaguesByCountryCode(countryCode: String): List<LeagueDTO> {
        return remoteDataSource.getLeaguesByCountryCode(countryCode)
    }

    suspend fun getLeaguesOfSeason(season: Int): List<LeagueDTO> {
        return remoteDataSource.getLeaguesOfSeason(season)
    }

    suspend fun getLeagueByIdBySeason(
        leagueId: Int,
        season: Int
    ): List<LeagueDTO> {
        return remoteDataSource.getLeagueByIdAndSeason(leagueId, season)
    }

    suspend fun getLeaguesByType(type: LeagueType): List<LeagueDTO> {
        return remoteDataSource.getLeaguesByType(type)
    }

    suspend fun getLeaguesByTypeById(type: LeagueType, id: Int)
            : List<LeagueDTO> {
        return remoteDataSource.getLeaguesByTypeById(type, id)
    }

    suspend fun getLeaguesByTypeByIdBySeason(type: LeagueType, id: Int, season: Int)
            : List<LeagueDTO> {
        return remoteDataSource.getLeagueByTypeByIdBySeason(type, id, season)
    }

    suspend fun getCurrentActiveLeagues(current: Boolean): List<LeagueDTO> {
        return remoteDataSource.getCurrentActiveLeagues(current)
    }

    suspend fun searchLeague(name: String): List<LeagueDTO> {
        return remoteDataSource.searchByLeagueName(name)
    }

    suspend fun getLeaguesSeasons(): List<LeagueDTO> {
        return remoteDataSource.getLeaguesSeasons()
    }
}
