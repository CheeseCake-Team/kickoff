package com.cheesecake.presentation.screens.teamstatistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamStatisticsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamStatisticsFragment : BaseFragment<FragmentTeamStatisticsBinding>() {
    override val layoutIdFragment = R.layout.fragment_team_statistics
    override val viewModel: TeamStatisticsViewModel by viewModels()


}