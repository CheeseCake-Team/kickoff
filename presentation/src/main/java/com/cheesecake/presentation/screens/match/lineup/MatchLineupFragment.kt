package com.cheesecake.presentation.screens.match.lineup

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchLineupBinding
import com.cheesecake.presentation.screens.match.statistics.MatchStatisticsArgs
import com.cheesecake.presentation.screens.match.statistics.MatchStatisticsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchLineupFragment : BaseFragment<FragmentMatchLineupBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_lineup
    override val viewModel: MatchLineupViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewTeamsLineup.adapter = ItemMatchTeamLineupAdapter()

        collect(viewModel.state) {
            if (!it.isLoading) {
                val firstTeamLineup = it.data.awayTeamLineup
                populateLineup(firstTeamLineup, binding.awayTeamContainer)
                rotateLineup(binding.awayTeamContainer, 90f)
                val secondTeamLineup = it.data.homeTeamLineup
                populateLineupReverse(secondTeamLineup, binding.homeTeamContainer)
                rotateLineup(binding.homeTeamContainer, 90f)
            }
        }
    }

    private fun rotateLineup(container: LinearLayout, degrees: Float) {
        container.rotation = degrees
    }

    private fun populateLineup(lineup: TeamData, container: LinearLayout) {
        val formation = lineup.formation.split("-").map { it.toInt() }
        container.removeAllViews()

        val goalkeeper = lineup.playerItemUiState.firstOrNull { it.playerPosition == "G" }
        if (goalkeeper != null) {
            val goalkeeperRow = createPlayerRow(goalkeeper, R.drawable.ic_shirt_blue)
            container.addView(goalkeeperRow)
        }

        var playerIndex = 1
        for (playersInRow in formation) {
            val playerRow = LinearLayout(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                gravity = Gravity.CENTER
            }
            for (i in 0 until playersInRow) {
                val player = lineup.playerItemUiState[playerIndex]
                playerIndex++
                val playerView = createPlayerView(player, R.drawable.ic_shirt_blue)
                playerRow.addView(playerView)
            }
            container.addView(playerRow)
        }


    }

    private fun populateLineupReverse(lineup: TeamData, container: LinearLayout) {
        val formation = lineup.formation.split("-").map { it.toInt() }.reversed()
        container.removeAllViews()

        var playerIndex = lineup.playerItemUiState.lastIndex
        for (playersInRow in formation) {
            val playerRow = LinearLayout(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                gravity = Gravity.CENTER
            }
            for (i in 0 until playersInRow) {
                val player = lineup.playerItemUiState[playerIndex]
                playerIndex--
                val playerView = createPlayerView(player, R.drawable.ic_shirt_red)
                playerRow.addView(playerView)
            }
            container.addView(playerRow)
        }

        val goalkeeper = lineup.playerItemUiState.firstOrNull { it.playerPosition == "G" }
        if (goalkeeper != null) {
            val goalkeeperRow = createPlayerRow(goalkeeper, R.drawable.ic_shirt_red)
            container.addView(goalkeeperRow)
        }
    }

    private fun createPlayerView(player: PlayerItemUiState, playerShirt: Int): View {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.item_player, null, false)
        val playerNumber: TextView = view.findViewById(R.id.playerNumber)
        val playerImageView: ImageView = view.findViewById(R.id.playerImageView)

        playerNumber.text = player.playerNumber.toString()
        playerImageView.setImageResource(playerShirt)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            val margin = resources.getDimensionPixelSize(R.dimen.spacing_4)
            setMargins(margin, margin, margin, margin)
        }
        view.layoutParams = params

        return view
    }

    private fun createPlayerRow(player: PlayerItemUiState, playerShirt: Int): LinearLayout {
        val playerRow = LinearLayout(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            gravity = Gravity.CENTER
        }
        val playerView = createPlayerView(player, playerShirt)
        playerRow.addView(playerView)
        return playerRow
    }

    companion object {
        @JvmStatic
        fun newInstance(fixtureId: Int) = MatchLineupFragment().apply {
            arguments = Bundle().apply {
                putInt(MatchLineupsArgs.FIXTURE_ID_ARG, fixtureId)
            }
        }
    }
}