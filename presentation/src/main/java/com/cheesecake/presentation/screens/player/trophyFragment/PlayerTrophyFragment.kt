package com.cheesecake.presentation.screens.player.trophyFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentPlayerTrophyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerTrophyFragment : BaseFragment<FragmentPlayerTrophyBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_player_trophy
    override val viewModel: PlayerTrophyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerTrophy.adapter = PlayerTrophyAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(playerId: Int) = PlayerTrophyFragment().apply {
            arguments = Bundle().apply {
                putInt(PlayerTrophyArgs.PLAYER_ID, playerId)
            }
        }
    }
}