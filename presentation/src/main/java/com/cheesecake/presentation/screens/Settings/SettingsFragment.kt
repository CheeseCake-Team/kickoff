package com.cheesecake.presentation.screens.Settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentSettingsBinding
import com.google.android.material.card.MaterialCardView
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override val layoutIdFragment = R.layout.fragment_settings
    override val viewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val themeSettingsCardView = view.findViewById<MaterialCardView>(R.id.card_view_theme_settings)
//        themeSettingsCardView.setOnClickListener {
//            val action = R.id.action_settingsFragment_to_darkThem
//            findNavController().navigate(action.toInt())
        }
    }
