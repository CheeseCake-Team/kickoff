package com.cheesecake.presentation.screens.topscorers

import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTopScorersBinding

class TopScorersFragment : BaseFragment<FragmentTopScorersBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_top_scorers
    override val viewModel: TopScorersViewModel by viewModels()


}