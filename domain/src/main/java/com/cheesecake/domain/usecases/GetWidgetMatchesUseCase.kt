package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetWidgetMatchesUseCase @Inject constructor(
    private val iFootballRepository: IFootballRepository
){

    suspend operator fun invoke(timezone:String,leagueId:Int,seasonId:Int): List<Fixture> {
        return iFootballRepository.getMatchesByLeagueIdAndSeason(timezone,leagueId,seasonId)
    }

}