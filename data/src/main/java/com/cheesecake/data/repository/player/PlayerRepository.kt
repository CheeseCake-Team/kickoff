package com.cheesecake.data.repository.player

import com.cheesecake.data.models.dto.PlayerDTO
import com.cheesecake.data.models.dto.SquadDTO
import com.cheesecake.data.remote.RemoteDataSource
import javax.inject.Inject

class PlayerRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getPlayerBySeasonByPlayerId(
        season: String,
        playerId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.getPlayerBySeasonByPlayerId(season, playerId)
    }

    suspend fun getPlayerBySeasonByTeamId(
        season: String,
        teamId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.getPlayerBySeasonByTeamId(season, teamId)
    }

    suspend fun getPlayerBySeasonByLeagueId(
        season: String,
        leagueId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.getPlayerBySeasonByLeagueId(season, leagueId)
    }

    suspend fun searchPlayerNameByTeamId(
        playerName: String,
        teamId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.searchPlayerNameByTeamId(playerName, teamId)
    }

    suspend fun searchPlayerNameByLeagueId(
        playerName: String,
        leagueId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.searchPlayerNameByLeagueId(playerName, leagueId)
    }

    suspend fun getPlayerSeasons(): List<Int> {
        return remoteDataSource.getPlayerSeasons()
    }

    suspend fun getSquadByPlayerId(playerId: Int): List<SquadDTO> {
        return remoteDataSource.getSquadByPlayerId(playerId)
    }

    suspend fun getSquadByTeamId(teamId: Int): List<SquadDTO> {
        return remoteDataSource.getSquadByTeamId(teamId)
    }

    suspend fun getTopScorers(
        seasonId: Int,
        leagueId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.getTopScorers(seasonId, leagueId)
    }

    suspend fun getTopAssists(
        seasonId: Int,
        leagueId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.getTopAssists(seasonId, leagueId)
    }

    suspend fun getTopYellowCards(
        seasonId: Int,
        leagueId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.getTopYellowCards(seasonId, leagueId)
    }

    suspend fun getTopRedCards(
        seasonId: Int,
        leagueId: Int
    ): List<PlayerDTO> {
        return remoteDataSource.getTopRedCards(seasonId, leagueId)
    }
}
