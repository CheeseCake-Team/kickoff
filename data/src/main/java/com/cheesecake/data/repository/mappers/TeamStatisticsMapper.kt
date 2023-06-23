import com.cheesecake.data.remote.models.TeamStatisticsDTO
import com.cheesecake.domain.entity.ScoreStats
import com.cheesecake.domain.entity.TeamStatisticsEntity

@JvmName("teamStatisticsDTOToTeamStatisticsEntity")
fun TeamStatisticsDTO.toEntity(): TeamStatisticsEntity =
    TeamStatisticsEntity(

        form = this.form.map { it.toString() },
        played = scoreStats(
            this.fixtures.played.home,
            this.fixtures.played.away,
            this.fixtures.played.total
        ),
        wins = scoreStats(
            this.fixtures.wins.home,
            this.fixtures.wins.away,
            this.fixtures.wins.total
        ),
        draws = scoreStats(
            this.fixtures.draws.home,
            this.fixtures.draws.away,
            this.fixtures.draws.total
        ),
        loses = scoreStats(
            this.fixtures.loses.home,
            this.fixtures.loses.away,
            this.fixtures.loses.total
        ),
        cleanSheet = scoreStats(
            this.cleanSheet.home,
            this.cleanSheet.away,
            this.cleanSheet.total
        ),
        failedToScore = scoreStats(
            this.failedToScore.home,
            this.failedToScore.away,
            this.failedToScore.total
        ),
        goalsFor = scoreStats(
            this.goals.goalsFor.total.home,
            this.goals.goalsFor.total.away,
            this.goals.goalsFor.total.total
        ),
        goalsAgainst = scoreStats(
            this.goals.goalsAgainst.total.home,
            this.goals.goalsAgainst.total.away,
            this.goals.goalsAgainst.total.total
        )
    )

private fun scoreStats(home: Float, away: Float, total: Float): ScoreStats =
    ScoreStats(home.toInt(), away.toInt(), total.toInt())