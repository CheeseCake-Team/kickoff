package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.LeagueEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class FavouriteLeagueUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase
) {

    suspend operator fun invoke(leagueId: Int, leagueSeason: Int): LeagueEntity? {
        getLeagueByIdAndSeasonUseCase(leagueId, leagueSeason)?.let {
            footballRepository.updateOrInsertLeague(
                LeagueEntity(
                    leagueId = it.leagueId,
                    leagueName = it.leagueName,
                    leagueLogo = it.leagueLogo,
                    leagueSeason = it.leagueSeason,
                    seasonStartYear = it.seasonStartYear,
                    seasonEndYear = it.seasonEndYear,
                    isFavourite = !it.isFavourite
                )
            )
        }
        return getLeagueByIdAndSeasonUseCase(leagueId, leagueSeason)
    }
}