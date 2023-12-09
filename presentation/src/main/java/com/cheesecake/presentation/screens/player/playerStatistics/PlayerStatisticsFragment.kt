package com.cheesecake.presentation.screens.player.playerStatistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentPlayerStatisticsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerStatisticsFragment : BaseFragment<FragmentPlayerStatisticsBinding>(){
    override val layoutIdFragment = R.layout.fragment_player_statistics
    override val viewModel: PlayerStatisticsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playerStatisticsRecyclerView.adapter = PlayerStatisticsAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(playerId: Int) = PlayerStatisticsFragment().apply {
            arguments = Bundle().apply {
                putInt(PlayerStatisticsArgs.PLAYER_ID, playerId)
            }
        }
    }

}