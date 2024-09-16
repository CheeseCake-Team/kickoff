package com.cheesecake.presentation.screens.timezone

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTimezoneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TimezoneFragment : BaseFragment<FragmentTimezoneBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_timezone
    override val viewModel: TimezoneViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        changeStatusBarColor()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleEvents()
        binding.timezoneRecyclerView.adapter = SeasonAdapter()
    }

    private fun handleEvents() {
        collect(viewModel.event) { event ->
            event.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: TimezoneEvents) {
        when(event) {
            is TimezoneEvents.OnBackClicked -> findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onPause() {
        super.onPause()
        resetStatusBarColor()
    }
}