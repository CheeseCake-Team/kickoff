package com.cheesecake.presentation.screens.favorite


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels

import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.base.BaseFragmentsAdapter
import com.cheesecake.presentation.databinding.FragmentFavoriteBinding
import com.cheesecake.presentation.screens.favoriteLeagues.FavoriteLeaguesFragment
import com.cheesecake.presentation.screens.favoriteTeams.FavoriteTeamsFragment
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override val layoutIdFragment = R.layout.fragment_favorite
    override val viewModel: FavouriteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val fragments = listOf(
            FavoriteLeaguesFragment(),
            FavoriteTeamsFragment(),
        )
        val fragmentsAdapter = BaseFragmentsAdapter((activity as AppCompatActivity), fragments)
        binding.favoriteViewPager.adapter = fragmentsAdapter
        TabLayoutMediator(binding.tabLayout, binding.favoriteViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "League"
                1 -> tab.text = "Team"
            }
        }.attach()
    }

}