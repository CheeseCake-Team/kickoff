package com.cheesecake.presentation.screens.season

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSeasonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeasonFragment : BaseFragment<FragmentSeasonBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_season
    override val viewModel: SeasonViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        changeStatusBarColor()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleEvents()
        binding.seasonsRecyclerView.adapter = SeasonAdapter()
    }

    private fun handleEvents() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(seasonEvent: SeasonEvent) {
        when (seasonEvent) {
            is SeasonEvent.OnBackClicked -> findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onPause() {
        super.onPause()
        resetStatusBarColor()
    }
}