package com.cheesecake.data.repository.player

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.PlayerDTO
import com.cheesecake.data.models.dto.SquadDTO
import retrofit2.Response
import javax.inject.Inject

class PlayerRepository @Inject constructor(private val playersApiService: IPlayersApiService) {

    suspend fun getPlayerBySeasonByPlayerId(
        season: String,
        playerId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.getPlayerBySeasonByPlayerId(season, playerId)
    }

    suspend fun getPlayerBySeasonByTeamId(
        season: String,
        teamId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.getPlayerBySeasonByTeamId(season, teamId)
    }

    suspend fun getPlayerBySeasonByLeagueId(
        season: String,
        leagueId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.getPlayerBySeasonByLeagueId(season, leagueId)
    }

    suspend fun searchPlayerNameByTeamId(
        playerName: String,
        teamId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.searchPlayerNameByTeamId(playerName, teamId)
    }

    suspend fun searchPlayerNameByLeagueId(
        playerName: String,
        leagueId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.searchPlayerNameByLeagueId(playerName, leagueId)
    }

    suspend fun getPlayerSeasons(): Response<BaseResponse<Int>> {
        return playersApiService.getPlayerSeasons()
    }

    suspend fun getSquadByPlayerId(playerId: Int): Response<BaseResponse<SquadDTO>> {
        return playersApiService.getSquadByPlayerId(playerId)
    }

    suspend fun getSquadByTeamId(teamId: Int): Response<BaseResponse<SquadDTO>> {
        return playersApiService.getSquadByTeamId(teamId)
    }

    suspend fun getTopScorers(
        seasonId: Int,
        leagueId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.getTopScorers(seasonId, leagueId)
    }

    suspend fun getTopAssists(
        seasonId: Int,
        leagueId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.getTopAssists(seasonId, leagueId)
    }

    suspend fun getTopYellowCards(
        seasonId: Int,
        leagueId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.getTopYellowCards(seasonId, leagueId)
    }

    suspend fun getTopRedCards(
        seasonId: Int,
        leagueId: Int
    ): Response<BaseResponse<PlayerDTO>> {
        return playersApiService.getTopRedCards(seasonId, leagueId)
    }
}