package com.cheesecake.presentation.screens.favoriteLeagues

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavoriteLeaguesBinding
import com.cheesecake.presentation.screens.favorite.FavoriteFragmentDirections
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteLeaguesFragment : BaseFragment<FragmentFavoriteLeaguesBinding>() {
    override val layoutIdFragment = R.layout.fragment_favorite_leagues
    override val viewModel: FavoriteLeaguesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favoriteLeaguesRecyclerView.adapter = FavoriteLeaguesAdapter()
        handleNavigation()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event?.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: FavoriteLeaguesNavigationEvent) {
        when (event) {
            is FavoriteLeaguesNavigationEvent.NavigateToLeague ->
                findNavController().navigate(FavoriteFragmentDirections.actionFavoriteFragmentToLeagueFragment())
        }
    }
}


