package com.cheesecake.ui.fragment.leagueTeams

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.usecases.GetAllTeamsInLeagueWithSeason
import com.cheesecake.ui.mapper.toUIModel
import com.cheesecake.ui.models.TeamUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class LeagueTeamsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamUIState> = emptyList(),
    val isError: String = "Error"
)

@HiltViewModel
class LeagueTeamsViewModel @Inject constructor(
    private val getAllTeamsInLeagueWithSeason: GetAllTeamsInLeagueWithSeason
) : ViewModel() {

    private val _leagueTeamsUIState = MutableStateFlow(LeagueTeamsUIState())
    val leagueTeamsUIState = _leagueTeamsUIState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    getAllTeamsInLeagueWithSeason(39, 2022).let { list ->
                        _leagueTeamsUIState.update { teamUIState ->
                            Log.i("getData: ", list.toString())
                            teamUIState.copy(data = list.map { it.toUIModel() }, isLoading = false)
                        }
                    }
                } catch (e: Exception) {
                    _leagueTeamsUIState.update {
                        it.copy(isError = e.message.toString())
                    }
                }
            }
        }
    }

}


