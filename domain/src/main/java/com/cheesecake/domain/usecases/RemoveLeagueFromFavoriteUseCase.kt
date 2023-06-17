package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository

class RemoveLeagueFromFavoriteUseCase(private val footballRepository: IFootballRepository) {

    suspend operator fun invoke(leagueId: Int){
        footballRepository.deleteLeagueById(leagueId)
    }
}