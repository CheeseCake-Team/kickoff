package com.cheesecake.presentation.screens.standings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentStandingsBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandingsFragment : BaseFragment<FragmentStandingsBinding>() {
    override val layoutIdFragment = R.layout.fragment_standings
    override val viewModel: StandingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
        binding.recyclerviewStandings.apply {
            adapter = StandingsAdapter()
            addItemDecoration(MaterialDividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                .apply {
                    isLastItemDecorated = false
                }
            )
        }
    }

    private fun handleNavigation() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: StandingNavigationEvent) {
        when (event) {
            is StandingNavigationEvent.NavigateBack -> {
                findNavController().navigateUp()
            }
        }
    }
}