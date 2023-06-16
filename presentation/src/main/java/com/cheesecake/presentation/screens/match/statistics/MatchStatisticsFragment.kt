package com.cheesecake.presentation.ui.match.statistics

import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchStatisticsBinding

class MatchStatisticsFragment : BaseFragment<FragmentMatchStatisticsBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_statistics
    override val viewModel: MatchStatisticsViewModel by viewModels()

}