package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetMatchDetailsUseCase @Inject constructor(
    private val footballRepository: IFootballRepository
) {

    suspend operator fun invoke(teamsId: String, date: String, timeZone: String): Match {
        return footballRepository.getMatchDetails(teamsId, date, timeZone)
    }
}