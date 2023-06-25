package com.cheesecake.presentation.screens.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentMatchBinding
import com.cheesecake.presentation.screens.match.events.MatchEventFragment
import com.cheesecake.presentation.screens.match.lineup.MatchLineupFragment
import com.cheesecake.presentation.screens.match.statistics.MatchStatisticsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchFragment : BaseFragment<FragmentMatchBinding>() {
    override val layoutIdFragment = R.layout.fragment_match
    override val viewModel: MatchViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor(R.color.appBar)
        handleNavigation()
        init()
    }

    private fun init() {
        val fragments = mutableListOf<Fragment>()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.args.observe(viewLifecycleOwner) {

                val matchStatisticsFragment = MatchStatisticsFragment.newInstance(it.fixtureId,it.state)
                val matchEventFragment = MatchEventFragment.newInstance(it.fixtureId, it.homeTeamId, it.awayTeamId,it.state)
                val matchLineupFragment = MatchLineupFragment.newInstance(it.fixtureId,it.state)

                fragments.addAll(
                    listOf(
                        matchStatisticsFragment,
                        matchEventFragment,
                        matchLineupFragment
                    )
                )

                val fragmentsAdapter = BaseFragmentsAdapter(
                    childFragmentManager,
                    requireActivity().lifecycle, fragments
                )
                binding.matchViewPager.adapter = fragmentsAdapter
                TabLayoutMediator(binding.tabLayout, binding.matchViewPager) { tab, position ->
                    when (position) {
                        0 -> tab.text = "Statistics"
                        1 -> tab.text = "Timeline"
                        2 -> tab.text = "Lineup"
                    }
                }.attach()
            }
        }
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: MatchEvents) {
        when (event) {
            is MatchEvents.BackClickEvent -> {
                findNavController().navigateUp()
            }
        }
    }
}