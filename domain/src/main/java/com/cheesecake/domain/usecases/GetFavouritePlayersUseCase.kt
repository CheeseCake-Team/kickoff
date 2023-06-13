package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject


class GetFavouritePlayersUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

}