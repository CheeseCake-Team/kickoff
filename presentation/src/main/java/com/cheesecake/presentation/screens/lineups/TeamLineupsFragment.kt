package com.cheesecake.presentation.screens.lineups

import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTeamLineupsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamLineupsFragment : BaseFragment<FragmentTeamLineupsBinding>() {

    override val layoutIdFragment: Int
        get() = R.layout.fragment_team_lineups

    override val viewModel: TeamLineupsViewModel by viewModels()
}