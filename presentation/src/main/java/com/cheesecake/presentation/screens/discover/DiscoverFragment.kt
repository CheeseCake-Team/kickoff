package com.cheesecake.presentation.screens.discover

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentDiscoverBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : BaseFragment<FragmentDiscoverBinding>() {
    override val layoutIdFragment = R.layout.fragment_discover
    override val viewModel: DiscoverViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewTeamCountry.adapter = DiscoverCountryAdapter()
    }

}