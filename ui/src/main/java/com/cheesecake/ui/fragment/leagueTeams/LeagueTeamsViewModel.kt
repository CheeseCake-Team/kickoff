package com.cheesecake.ui.fragment.leagueTeams

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.Entity.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<Team> = emptyList(),
    val isError: String = "Error"
)

@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
//    private val getAllTeamsInLeagueWithSeason: GetAllTeamsInLeagueWithSeason
 //   private val getSingleFixtureByIdUseCase: GetSingleFixtureByIdUseCase
) : ViewModel() {

    private val _leagueTeamsUIState = MutableStateFlow(LeagueTeamsUIState())
    val leagueTeamsUIState = _leagueTeamsUIState.asStateFlow()


//    .collect { list ->
//        // Update the ViewModel with the successful result
//        _leagueTeamsUIState.update {
//            it.copy(data = list, isLoading = false, isError = null)
//        }
//    }
//} catch (e: Exception) {
//    // Handle the exception and update the ViewModel with the error message
//    _leagueTeamsUIState.update {
//        it.copy(isError = e.message)
//    }
//}
}