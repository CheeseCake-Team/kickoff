package com.cheesecake.presentation.screens.settings

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override val layoutIdFragment = R.layout.fragment_settings
    override val viewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeStatusBarColor()

        binding.cardViewThemeSettings.setOnClickListener {
            val darkThemeFragment = DarkTheme()
            darkThemeFragment.show(childFragmentManager, darkThemeFragment.tag)
        }
        binding.cardViewFavourites.setOnClickListener {
            findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToFavoriteFragment())
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onPause() {
        super.onPause()
        resetStatusBarColor()
    }
}