package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamPlayers
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetAllTeamPlayersUSeCase  @Inject constructor(
    private val footballRepository: IFootballRepository
) {

    suspend operator fun invoke(season:String,teamId:Int): List<TeamPlayers> {
        return  footballRepository.getAllPlayersByTeamIdAndSeason(season,teamId)

    }

}