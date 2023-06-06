package com.cheesecake.domain.usecases

import com.cheesecake.domain.models.League
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetLeagueByIdAndSeason @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    private suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): Flow<League?> {
        val localLeague = footballRepository.getLocallyLeagueByIdAndSeason(leagueId, leagueSeason)
        if (localLeague == null) {
            val remoteLeague = footballRepository.getRemotelyLeagueByIdAndSeason(leagueId, leagueSeason)
            remoteLeague?.let {
                footballRepository.updateOrInsertLeague(it)
            }
        }
        return flowOf(footballRepository.getLocallyLeagueByIdAndSeason(leagueId, leagueSeason))
    }

}