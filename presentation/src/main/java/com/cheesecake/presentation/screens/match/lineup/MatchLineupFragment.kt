package com.cheesecake.presentation.screens.match.lineup

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.PlayerLineup
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchLineupBinding
import com.cheesecake.presentation.screens.match.lineup.MatchLineupViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchLineupFragment : BaseFragment<FragmentMatchLineupBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_lineup
    override val viewModel: MatchLineupViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collect(viewModel.state){
            val firstTeamLineup = it.data.homeTeamLineup
            populateLineup(firstTeamLineup, binding.homeTeamContainer)
            rotateLineup(binding.homeTeamContainer, 90f)
            val secondTeamLineup = it.data.awayTeamLineup
            populateLineupReverse(secondTeamLineup, binding.awayTeamContainer)
            rotateLineup(binding.awayTeamContainer, 90f)


        }
    }

    private fun rotateLineup(container: LinearLayout, degrees: Float) {
        container.rotation = degrees
    }

    private fun populateLineup(lineup: FixtureLineupUiState, container: LinearLayout) {
        val formation = lineup.formation.split("-").map { it.toInt() }
        val cellWidth = 200
        container.removeAllViews()

        // Add goalkeeper row
        val goalkeeper = lineup.playerItemUiState.firstOrNull { it.playerPosition == "G" }
        if (goalkeeper != null) {
            val goalkeeperRow = createPlayerRow(goalkeeper, R.drawable.player_shirt)
            container.addView(goalkeeperRow)
        }

        // Add player rows
        var playerIndex = 1 // Start from index 1 to skip the goalkeeper
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
                val playerView = createPlayerView(player, R.drawable.player_shirt)
                playerRow.addView(playerView)
            }
            container.addView(playerRow)
        }


    }

    private fun populateLineupReverse(lineup: FixtureLineupUiState, container: LinearLayout) {
        val formation = lineup.formation.split("-").map { it.toInt() }
        val cellWidth = 200
        container.removeAllViews()

        // Add player rows in reverse order
        var playerIndex = lineup.playerItemUiState.lastIndex // Start from the last index
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
                val playerView = createPlayerView(player, R.drawable.ic_red)
                playerRow.addView(playerView)
            }
            container.addView(playerRow)
        }

        // Add goalkeeper row at the bottom
        val goalkeeper = lineup.playerItemUiState.firstOrNull { it.playerPosition == "G" }
        if (goalkeeper != null) {
            val goalkeeperRow = createPlayerRow(goalkeeper, R.drawable.ic_red)
            container.addView(goalkeeperRow)
        }
    }

    private fun createPlayerView(player: PlayerItemUiState, playerShirt: Int): View {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.item_player, null, false)
        val playerNumber: TextView = view.findViewById(R.id.playerNumber)
        val playerImageView: ImageView = view.findViewById(R.id.playerImageView)
        val playerName: TextView = view.findViewById(R.id.playerName)

        playerNumber.text = player.playerNumber.toString()
        playerImageView.setImageResource(playerShirt)
        playerName.text = player.playerName

        // Apply margins to the view
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            val marginV = resources.getDimensionPixelSize(R.dimen.player_v)

            val margin = resources.getDimensionPixelSize(R.dimen.player_margin)
            setMargins(marginV, margin, marginV, margin)
            // You can adjust the values accordingly.
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


}