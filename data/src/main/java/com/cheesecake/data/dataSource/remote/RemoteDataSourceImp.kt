package com.cheesecake.data.dataSource.remote

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.base.BaseStaticResponse
import com.cheesecake.data.models.dto.TeamCountriesDTO
import com.cheesecake.data.models.dto.TeamInformationDTO
import com.cheesecake.data.models.dto.TeamStatisticsDTO
import com.cheesecake.data.remote.teams.ITeamsApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val service: ITeamsApiService
): RemoteDataSource {

    override suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int,
        seasonId: Int
    ): List<TeamInformationDTO> {
       return wrap { service.getTeamsByLeagueAndSeason(leagueId,seasonId) }
    }

    override suspend fun getTeamById(teamId: Int): Response<BaseResponse<TeamInformationDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): Response<BaseStaticResponse<TeamStatisticsDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamSeasons(teamId: Int): Response<BaseResponse<Int>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTeamCountries(): Response<BaseResponse<TeamCountriesDTO>> {
        TODO("Not yet implemented")
    }


    private suspend fun <T> wrap(
        function: suspend () -> Response<BaseResponse<T>>,
    ): List<T> {
        val response = function()
        return if (response.isSuccessful) {
            response.body()?.response
            } else {
            throw Throwable(" Not Success Request ")
        } as List<T>
    }

}