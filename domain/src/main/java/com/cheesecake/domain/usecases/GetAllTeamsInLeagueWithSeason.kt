package com.cheesecake.domain.usecases

//import com.cheesecake.data.repository.teams.TeamsRepository
//import javax.inject.Inject
//
//class GetAllTeamsInLeagueWithSeason @Inject constructor(
//    private val teamsRepository: TeamsRepository,
//) {
//
////    suspend operator fun invoke(leagueId: Int, season: Int) : Flow<List<Team>> {
////        return teamsRepository.getTeamsByLeagueAndSeason(leagueId, season).map { localTeamsDto ->
////            localTeamsDto.map { it.toEntity() }
////        }
////    }
//
//
//}