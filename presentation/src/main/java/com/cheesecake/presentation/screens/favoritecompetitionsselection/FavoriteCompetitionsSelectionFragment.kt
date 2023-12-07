package com.cheesecake.presentation.screens.favoritecompetitionsselection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavoriteCompetitionsSelectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteCompetitionsSelectionFragment :
    BaseFragment<FragmentFavoriteCompetitionsSelectionBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_favorite_competitions_selection
    override val viewModel: FavoriteCompetitionSelectionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.competitionsRecyclerView.adapter = FavoriteCompetitionsSelectionAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: FavoriteCompetitionSelectionNavigationEvent) {
        val action = when (event) {
            is FavoriteCompetitionSelectionNavigationEvent.NavigateToFavoriteTeamsSelection -> {
                FavoriteCompetitionsSelectionFragmentDirections
                    .actionFavoriteCompetitionsSelectionFragmentToFavoriteTeamsSelectionFragment()
            }
        }
        findNavController().navigate(action)
    }
}