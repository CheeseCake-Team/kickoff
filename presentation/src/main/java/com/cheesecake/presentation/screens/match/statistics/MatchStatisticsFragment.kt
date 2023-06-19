package com.cheesecake.presentation.screens.match.statistics

 import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.cheesecake.presentation.R
import com.cheesecake.presentation.base.BaseFragment
import com.cheesecake.presentation.databinding.FragmentMatchStatisticsBinding
 import com.cheesecake.presentation.screens.match.statistics.MatchStatisticsArgs.Companion.FIXTURE_ID_ARG
 import com.cheesecake.presentation.ui.match.statistics.MatchStatisticsAdapter
 import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchStatisticsFragment : BaseFragment<FragmentMatchStatisticsBinding>() {
    override val layoutIdFragment = R.layout.fragment_match_statistics
    override val viewModel: MatchStatisticsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = MatchStatisticsAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(fixtureId: Int) = MatchStatisticsFragment().apply {
            arguments = Bundle().apply {
                putInt(FIXTURE_ID_ARG, fixtureId)
            }
        }
    }
}