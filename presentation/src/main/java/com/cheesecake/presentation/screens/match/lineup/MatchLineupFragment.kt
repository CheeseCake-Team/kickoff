package com.cheesecake.presentation.screens.match.lineup

import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchLineupBinding
import com.cheesecake.presentation.screens.match.lineup.MatchLineupViewModel

class MatchLineupFragment : BaseFragment<FragmentMatchLineupBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_lineup
    override val viewModel: MatchLineupViewModel by viewModels()

}