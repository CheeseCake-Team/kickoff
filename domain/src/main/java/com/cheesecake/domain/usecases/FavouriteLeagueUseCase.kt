package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class FavouriteLeagueUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase
) {

    suspend operator fun invoke(leagueId: Int, leagueSeason: Int): League {
        getLeagueByIdAndSeasonUseCase(leagueId,).let {
            footballRepository.updateOrInsertLeague(
                League(
                    leagueId = it.leagueId,
                    name = it.name,
                    imageUrl = it.imageUrl,
                    season = it.season,
                    seasonStartYear = it.seasonStartYear,
                    seasonEndYear = it.seasonEndYear,
                    isFavourite = !it.isFavourite,
                    countryName = it.countryName,
                    leagueTypeName = it.leagueTypeName,
                    leagueCount = 1
                )
            )
        }
        return getLeagueByIdAndSeasonUseCase(leagueId)
    }
}