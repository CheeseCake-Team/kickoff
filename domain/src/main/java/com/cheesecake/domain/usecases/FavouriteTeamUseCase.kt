package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class FavouriteTeamUseCase@Inject constructor(
    private val footballRepository: IFootballRepository,
    private val getTeamByIdUseCase: GetTeamByIdUseCase) {

    suspend operator fun invoke(teamId: Int): Team {
        getTeamByIdUseCase(teamId).let {
            footballRepository.updateOrInsertTeam(
                Team(
                    id = it.id,
                    name = it.name,
                    yearFounded = it.yearFounded,
                    country = it.country,
                    stadiumCapacity  = it.stadiumCapacity,
                    stadiumName = it.stadiumName,
                    imageUrl = it.imageUrl,
                    isFavourite = !it.isFavourite,
                ),
                39,2022
            )
        }
        return getTeamByIdUseCase(teamId)
    }
}