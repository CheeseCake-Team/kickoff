package com.cheesecake.presentation.screens.standings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.cheesecake.domain.usecases.GetAllTeamsInLeagueWithSeasonUseCase
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentStandingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandingsFragment : BaseFragment<FragmentStandingsBinding>() {
    override val layoutIdFragment = R.layout.fragment_standings
    override val viewModel: StandingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewStandings.adapter = StandingsAdapter()
    }
}