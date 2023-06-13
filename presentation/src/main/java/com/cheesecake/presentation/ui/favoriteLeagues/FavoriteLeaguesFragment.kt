package com.cheesecake.presentation.ui.favoriteLeagues

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavoriteLeaguesBinding
import com.cheesecake.presentation.ui.leagueMatches.LeagueMatchesDateMatchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteLeaguesFragment : BaseFragment<FragmentFavoriteLeaguesBinding>() {
    override val layoutIdFragment = R.layout.fragment_favorite_leagues
    override val viewModel: FavoriteLeaguesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favoriteLeaguesRecyclerView.adapter = LeagueMatchesDateMatchAdapter()
    }
}