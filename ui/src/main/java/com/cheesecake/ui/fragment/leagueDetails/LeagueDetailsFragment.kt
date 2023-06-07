package com.cheesecake.ui.fragment.leagueDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.ui.R
import com.cheesecake.ui.base.BaseFragment
import com.cheesecake.ui.databinding.FragmentLeagueDetailsBinding


class LeagueDetailsFragment: BaseFragment<FragmentLeagueDetailsBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_league_details
    override val viewModel: LeagueDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler_view_clubs_scores.adapter = DetailsAdapter()
    }

}