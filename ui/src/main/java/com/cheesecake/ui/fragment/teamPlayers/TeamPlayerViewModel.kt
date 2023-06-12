package com.cheesecake.ui.fragment.teamPlayers
import com.cheesecake.domain.entity.TeamPlayers
import com.cheesecake.domain.usecases.GetAllTeamPlayersUSeCase
import com.cheesecake.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class PlayersTeamStatisticsUIState(
    val isLoading: Boolean = true,
    val data: List<TeamPlayers> = emptyList(),
    val isError: String = "Error"
)
@HiltViewModel
 class TeamPlayerViewModel@Inject constructor(
    private val getAllTeamPlayersUSeCase: GetAllTeamPlayersUSeCase
) : BaseViewModel<PlayersTeamStatisticsUIState>() {

    override val uiState=PlayersTeamStatisticsUIState()

    init {
        getData()
    }
    private fun getData() {
        tryToExecute(
            { getAllTeamPlayersUSeCase("0",0)},
            ::onSuccess,
            ::onError
        )
    }




    private fun onSuccess(result: List<TeamPlayers>) {
        _state.update { it.copy(data = result, isLoading = false)
    }}

    private fun onError(e: Throwable) {
        _state.update {
            it.copy(isError = e.message.toString())
        }
    }
}