package com.cheesecake.presentation.screens.favoriteLeagues

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavoriteLeaguesBinding
import com.cheesecake.presentation.utils.collect
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


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
        lifecycleScope.launch {
            collect(viewModel.favoriteLeaguesEvent) { event ->
                event?.getContentIfNotHandled()?.let { onEvent(it) }
            }
        }
    }

    private fun onEvent(event: NavigateEvent) {
        when (event) {
            is NavigateEvent.NavigateToLeague ->
                findNavController().navigate()
        }
    }
}


