package com.cheesecake.ui.fragment.leagueTeams

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.models.TeamEntity
import com.cheesecake.domain.usecases.fixture.GetSingleFixtureByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamEntity> = emptyList(),
    val isError: String = "Error"
)

@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
//    private val getAllTeamsInLeagueWithSeason: GetAllTeamsInLeagueWithSeason
    private val getSingleFixtureByIdUseCase: GetSingleFixtureByIdUseCase
) : ViewModel() {

    private val _leagueTeamsUIState = MutableStateFlow(LeagueTeamsUIState())
    val leagueTeamsUIState = _leagueTeamsUIState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
//                getAllTeamsInLeagueWithSeason(39, 2022)
//                    .collect { list ->
//                        _leagueTeamsUIState.update {
//                            delay(2000)
//                            it.copy(data = list, isLoading = false)
//                        }
//                    }

                val f = getSingleFixtureByIdUseCase("Europe/London", 239625)
                Log.d("TAG", "getData: f")
            } catch (e: Exception) {
                _leagueTeamsUIState.update {
                    Log.i("TAGgggggggggggggggggg", e.message.toString())
                    it.copy(isError = e.message.toString())
                }
            }

        }
    }

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