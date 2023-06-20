package com.cheesecake.presentation.screens.match.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchEventBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchEventFragment : BaseFragment<FragmentMatchEventBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_event
    override val viewModel: MatchEventViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.matchesEventsRecyclerView.adapter = MatchEventAdapter()
    }
}