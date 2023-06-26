package com.cheesecake.presentation.screens.favTeamsSelection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavTeamsSelectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavTeamsSelectionFragment : BaseFragment<FragmentFavTeamsSelectionBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_fav_teams_selection
    override val viewModel: FavTeamsSelectionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.allTeamsRecyclerView.adapter = FavTeamsSelectionAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: FavTeamsSelectionNavigationEvent) {
        when (event) {
            is FavTeamsSelectionNavigationEvent.NavigateToHome -> {
                requireActivity().finish()
            }
        }
    }
}