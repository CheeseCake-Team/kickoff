package com.cheesecake.presentation.ui.favoriteTeams

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentFavoriteTeamsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteTeamsFragment : BaseFragment<FragmentFavoriteTeamsBinding>() {
    override val layoutIdFragment = R.layout.fragment_favorite_teams

    override val viewModel: FavoriteTeamsViewModel  by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FavoriteTeamsAdapter()
        binding.favoriteTeamsRecyclerView.adapter = adapter
    }

}