package com.cheesecake.domain.usecases


import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class AddFavouriteTeamListUseCase @Inject constructor(
    private val Repository: IFootballRepository
) {

    private val selectedTeams: MutableList<Team> = mutableListOf()

    fun addTeam(team: Team) {
        selectedTeams.find { it == team }?.let {
            selectedTeams.remove(team.copy(isFavourite = false))
        } ?: run {
            selectedTeams.add(team.copy(isFavourite = true))
        }
    }

    suspend fun execute(): Boolean {
        Repository.addTeamsList(selectedTeams)
        return true
    }

}