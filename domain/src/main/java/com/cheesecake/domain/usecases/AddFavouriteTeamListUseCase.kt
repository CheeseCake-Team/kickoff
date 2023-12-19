package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class AddFavouriteTeamListUseCase @Inject constructor(
    private val repository: IFootballRepository
) {
    private val selectedTeams: MutableList<Triple<Team, Int, Int>> = mutableListOf()

    fun addTeam(team: Team, leagueId: Int, season: Int) {
        selectedTeams.find { it.first == team }?.let { (team, leagueId, season) ->
            selectedTeams.remove(Triple(team.copy(isFavourite = false), leagueId, season))
        } ?: run {
            selectedTeams.add(Triple(team.copy(isFavourite = true), leagueId, season))
        }
    }

    suspend fun execute(): Boolean {
        val triples = selectedTeams.toList()
        repository.addTeamsList(triples)
        return true
    }
}