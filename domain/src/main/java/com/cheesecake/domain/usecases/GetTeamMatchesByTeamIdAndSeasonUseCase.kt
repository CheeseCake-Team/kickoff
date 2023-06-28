package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.repository.IFootballRepository
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class GetTeamMatchesByTeamIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(
        timeZone: String,
        teamId: Int,
        season: Int
    ): List<Fixture> {
        return footballRepository.getMatchesByTeamIdAndSeason(timeZone, season, teamId)
            .sortedBy { it.matchDate }
            .toList()
            .reversed()

    }
}