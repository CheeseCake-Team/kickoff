package com.cheesecake.presentation.screens.favoriteteamsselection

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavoriteTeamsSelectionBinding
import com.cheesecake.presentation.screens.mainactivity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteTeamsSelectionFragment : BaseFragment<FragmentFavoriteTeamsSelectionBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_favorite_teams_selection
    override val viewModel: FavoriteTeamsSelectionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.allTeamsRecyclerView.adapter = FavoriteTeamsSelectionAdapter()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
            viewModel.setOnboardingShown()
        }
    }

    private fun onEvent(event: FavoriteTeamsSelectionNavigationEvent) {
        when (event) {
            is FavoriteTeamsSelectionNavigationEvent.NavigateToHome -> {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }
    }
}