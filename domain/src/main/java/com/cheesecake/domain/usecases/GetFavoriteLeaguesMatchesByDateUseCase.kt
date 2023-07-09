package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

class GetFavoriteLeaguesMatchesByDateUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
    private val getFavoriteLeaguesUseCase: GetFavoriteLeaguesUseCase
) {

    suspend operator fun invoke(
        date: Date,
        timeZone: String,
    ): Flow<List<Pair<League, List<Fixture>>>> {
        return getFavoriteLeaguesUseCase().map { list ->
            list.map { league ->
                val matches = footballRepository.getMatchesByLeagueIdAndSeason(
                    timeZone,
                    league.leagueId,
                    league.season.last()
                )
                    .filter { it.matchDate.isSameDay(date) }
                league to matches
            }
        }
    }

    private fun Date.isSameDay(otherDate: Date): Boolean {
        val localDate1 = this.toLocalDate()
        val localDate2 = otherDate.toLocalDate()
        return localDate1.isEqual(localDate2)
    }

    private fun Date.toLocalDate(): LocalDate =
        toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

}
