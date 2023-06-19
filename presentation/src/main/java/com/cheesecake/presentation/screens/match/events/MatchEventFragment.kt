package com.cheesecake.presentation.screens.match.events

import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchEventBinding
import com.cheesecake.presentation.screens.match.events.MatchEventViewModel


class MatchEventFragment : BaseFragment<FragmentMatchEventBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_event
    override val viewModel: MatchEventViewModel by viewModels()

}