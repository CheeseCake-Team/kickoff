package com.cheesecake.presentation.screens.player.trophyFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentTrophyBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class TrophyFragment : BaseFragment<FragmentTrophyBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_trophy
    override val viewModel: TrophyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerTrophy.adapter = TrophyAdapter()
    }

}