package com.cheesecake.presentation.screens.favorite.favoritecompetitions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavoriteCompetitionsBinding
import com.cheesecake.presentation.screens.favorite.FavoriteFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteCompetitionsFragment : BaseFragment<FragmentFavoriteCompetitionsBinding>() {
    override val layoutIdFragment = R.layout.fragment_favorite_competitions
    override val viewModel: FavoriteLeaguesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favoriteLeaguesRecyclerView.adapter = FavoriteCompetitionsAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: FavoriteCompetitionsNavigationEvent) {
        when (event) {
            is FavoriteCompetitionsNavigationEvent.NavigateToCompetition ->
                findNavController().navigate(
                    FavoriteFragmentDirections.actionFavoriteFragmentToLeagueFragment(event.competitionId)
                )
        }
    }
}