package com.cheesecake.presentation.screens.player

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentPlayerBinding
import com.cheesecake.presentation.screens.player.playerStatistics.PlayerStatisticsFragment
import com.cheesecake.presentation.screens.player.trophyFragment.PlayerTrophyFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerFragment : BaseFragment<FragmentPlayerBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_player
    override val viewModel: PlayerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor()
        handleNavigation()
        initializeTabLayout()
    }

    private fun initializeTabLayout() {
        val fragments = listOf(
            PlayerStatisticsFragment.newInstance(
                viewModel.playerNavigationArgs.season,
                viewModel.playerNavigationArgs.playerId
            ),
            PlayerTrophyFragment.newInstance(viewModel.playerNavigationArgs.playerId),
        )
        val fragmentsAdapter = BaseFragmentsAdapter(
            childFragmentManager,
            requireActivity().lifecycle, fragments
        )
        binding.playerViewPager.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabLayout, binding.playerViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Statistics"
                1 -> tab.text = "Trophy"
            }
        }.attach()
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: PlayerNavigationEvent) {
        when (event) {
            is PlayerNavigationEvent.NavigateBack -> {
                findNavController().navigateUp()
            }
        }
    }
}