package com.cheesecake.data.dataSource.remote

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.base.BaseStaticResponse
import com.cheesecake.data.models.dto.TeamCountriesDTO
import com.cheesecake.data.models.dto.TeamInformationDTO
import com.cheesecake.data.models.dto.TeamStatisticsDTO
import retrofit2.Response

//interface RemoteDataSource {
//
//    suspend fun getTeamsByLeagueAndSeason(
//        leagueId: Int,
//        seasonId: Int
//    ): List<TeamInformationDTO>
//
//    suspend fun getTeamById(
//        teamId: Int
//    ): Response<BaseResponse<TeamInformationDTO>>
//
//    suspend fun getTeamStatistics(
//        teamId: Int,
//        season: Int,
//        leagueId: Int
//    ): Response<BaseStaticResponse<TeamStatisticsDTO>>
//
//    suspend fun getTeamSeasons(
//        teamId: Int
//    ): Response<BaseResponse<Int>>
//
//    suspend fun getTeamCountries(): Response<BaseResponse<TeamCountriesDTO>>
//}