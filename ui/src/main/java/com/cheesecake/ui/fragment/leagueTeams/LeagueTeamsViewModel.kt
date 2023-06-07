package com.cheesecake.ui.fragment.leagueTeams

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.usecases.GetAllTeamsInLeagueWithSeason
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
    val data: List<TeamEntity> = emptyList(),
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
                        _leagueTeamsUIState.update {
                            Log.i("getData: ", list.toString())
                            it.copy(data = list, isLoading = false)
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