package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.Trophy
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class ManagePlayerUseCase @Inject constructor(
    private val footballRepository: IFootballRepository
) {
    /**
     * @author Hassan
     * */
    suspend fun getPlayerTrophy(playerId: Int): List<Trophy> {
        return footballRepository.getPlayerTrophy(playerId)
    }

    /**
     * @author Abdurrahman
     * */
    suspend fun getPlayerStatistics(season: Int, playerId: Int): PlayerStatistics {
        return footballRepository.getPlayerFullStatistics(season, playerId)
    }

    /**
     * @author Abdurrahman
     * */
    suspend fun getTopScorersInCompetition(leagueId: Int, season: Int): List<PlayerStatistics> {
        return footballRepository.getTopScorersInCompetition(leagueId, season)
    }
}