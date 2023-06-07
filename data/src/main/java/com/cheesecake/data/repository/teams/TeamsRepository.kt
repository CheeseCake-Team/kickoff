package com.cheesecake.data.repository.teams

import com.cheesecake.data.repository.LocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class TeamsRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
//    private val remoteDataSource: RemoteDataSource,
    private val defaultDispatcher: CoroutineDispatcher,
) {
//
//    suspend fun getTeamsByLeagueAndSeason(
//        leagueId: Int,
//        seasonId: Int
//    ): Flow<List<TeamLocalDto>> {
//        return try {
//            refresh(leagueId, seasonId)
//            localDataSource.getAllTeams()
//        } catch (e: Exception) {
//            throw Exception("Failed to connect to the server. Please check your internet connection and try again.")
//        }
//    }
//
//    private suspend fun refresh(leagueId: Int, seasonId: Int) {
//        withContext(defaultDispatcher) {
////            try {
//            val remoteTeams = remoteDataSource.getTeamsByLeagueAndSeason(leagueId, seasonId)
//            localDataSource.deleteAll()
//            Log.d("refresh: ", "here")
//            remoteTeams.let { teamInformation ->
//                localDataSource.upsertAll(teamInformation.map {
//                    it.toLocal()
//                })
//            }
////            } catch (e: Exception) {
////                val errorMessage = when (e) {
////                    is IOException -> "Failed to connect to the server. Please check your internet connection and try again."
////                    is HttpException -> "An error occurred while fetching data. Please try again later."
////                    else -> "An unexpected error occurred. Please try again later."
////                }
////                Log.d("refresh: ", e.message.toString())
////                Log.d("refresh: ",errorMessage)
////                // Display error message to the user (e.g., show a toast or update UI)
////                // You can use the Android Toast API to show a temporary message
////                // Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
////                // Alternatively, you can update a TextView or any other UI element with the error message
////                // textViewError.text = errorMessage
////               // throw Exception(errorMessage)
////            }
//        }
//    }
//
//    suspend fun getTeamById(teamId: Int): Response<BaseResponse<TeamInformationResponse>> {
//        return remoteDataSource.getTeamById(teamId)
//    }
//
//    suspend fun getTeamStatistics(
//        teamId: Int,
//        season: Int,
//        leagueId: Int
//    ): Response<BaseStaticResponse<TeamStatisticsDTO>> {
//        return remoteDataSource.getTeamStatistics(teamId, season, leagueId)
//    }
//
//    suspend fun getTeamSeasons(teamId: Int): Response<BaseResponse<Int>> {
//        return remoteDataSource.getTeamSeasons(teamId)
//    }
//
//    suspend fun getTeamCountries(): Response<BaseResponse<TeamCountriesDTO>> {
//        return remoteDataSource.getTeamCountries()
//    }
}


