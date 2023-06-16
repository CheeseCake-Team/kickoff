package com.cheesecake.presentation.screens.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.cheesecake.presentation.databinding.SheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DarkTheme : BottomSheetDialogFragment() {

    private var _binding: SheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lightModeButton.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            dismiss() // Close the bottom sheet dialog
        }

        binding.darkModeButton.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            dismiss() // Close the bottom sheet dialog
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
