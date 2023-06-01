package com.cheesecake.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentTeamsLeagueBinding
import com.cheesecake.ui.utils.TeamsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestFragment : BaseFragment<FragmentTeamsLeagueBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_teams_league
    override val viewModel: LeagueTeamsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.teamsRecyclerView.adapter = TeamsAdapter()
    }

}