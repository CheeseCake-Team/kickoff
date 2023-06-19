//package com.cheesecake.domain.usecases
//
//import com.cheesecake.domain.entity.League
//import com.cheesecake.domain.entity.Team
//import com.cheesecake.domain.repository.IFootballRepository
//import javax.inject.Inject
//
//class FavouriteTeamUseCase@Inject constructor(
//    private val footballRepository: IFootballRepository,
//    private val getTeamByIdUseCase: GetTeamByIdUseCase) {
//
//    suspend operator fun invoke(teamId: Int): Team {
//      getTeamByIdUseCase(teamId ).let {
//            footballRepository.updateOrInsertT(
//                League(
//                    leagueId = it.leagueId,
//                    leagueName = it.leagueName,
//                    leagueLogo = it.leagueLogo,
//                    leagueSeason = it.leagueSeason,
//                    seasonStartYear = it.seasonStartYear,
//                    seasonEndYear = it.seasonEndYear,
//                    isFavourite = !it.isFavourite,
//                    country = it.country
//                )
//            )
//        }
//        return getLeagueByIdAndSeasonUseCase(leagueId, leagueSeason)
//    }
//}