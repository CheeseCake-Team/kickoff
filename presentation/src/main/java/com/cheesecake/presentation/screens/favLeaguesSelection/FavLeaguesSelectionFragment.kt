package com.cheesecake.presentation.screens.favLeaguesSelection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavLeagueSelectionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavLeaguesSelectionFragment : BaseFragment<FragmentFavLeagueSelectionBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_fav_league_selection
    override val viewModel: FavLeagueSelectionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.allLeaguesRecyclerView.adapter = FavLeagueSelectionAdapter()
    }
}