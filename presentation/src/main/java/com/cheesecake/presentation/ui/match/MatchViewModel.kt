package com.cheesecake.presentation.ui.match

import com.cheesecake.domain.usecases.FavouriteLeagueUseCase
import com.cheesecake.domain.usecases.GetLeagueByIdAndSeasonUseCase
import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchViewModel
@Inject constructor(
    private val getLeagueByIdAndSeasonUseCase: GetLeagueByIdAndSeasonUseCase,
) :BaseViewModel<MatchUIState>(MatchUIState()) {

    init {

    }
}