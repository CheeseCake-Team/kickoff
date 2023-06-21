package com.cheesecake.presentation.screens.match.events

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchEventBinding
import com.cheesecake.presentation.screens.match.events.MatchEventArgs.Companion.AWAY_TEAM_ID_ARG
import com.cheesecake.presentation.screens.match.events.MatchEventArgs.Companion.HOME_TEAM_ID_ARG
import com.cheesecake.presentation.screens.match.events.MatchEventArgs.Companion.MATCH_FIXTURE_ID_ARG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchEventFragment : BaseFragment<FragmentMatchEventBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_event
    override val viewModel: MatchEventViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = viewModel.matchEventArgs

        Log.d("TAG", "onViewCreated: ${args.homeTeamId } sdsd ${args.awayTeamId}}")

        binding.matchesEventsRecyclerView.adapter =
            MatchEventAdapter(args.homeTeamId, args.awayTeamId)
    }

    companion object {
        @JvmStatic
        fun newInstance(fixtureID: Int, homeTeamID: Int, awayTeamId: Int) =
            MatchEventFragment().apply {
                arguments = Bundle().apply {
                    putInt(MATCH_FIXTURE_ID_ARG, fixtureID)
                    putInt(HOME_TEAM_ID_ARG, homeTeamID)
                    putInt(AWAY_TEAM_ID_ARG, awayTeamId)
                }
            }
    }

}